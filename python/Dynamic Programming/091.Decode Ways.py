# coding=utf-8
import sys


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

'''
动态规划, 看一位是0还是1~9，看两位是不是在10~26之间。dp[N] = M 表示字符串s的前N位有M种解码方式。

f[i]表示从头到弟i位有多少种方法
那么就是
i如果是能和i-1构成 1..26...
那么f[i] = f[i-1] + f[i-2]
意思就是i单独的一种方法，和与i-1一起构成两位的方法。
如果不能f[i] = f[i-1]

到此，感觉就做完啦。
不过。。。不过。。。我没有考虑0啊。。。
有0要特殊处理。。。
首先第一位肯定不能有0 ， 也不能有连续的0
10，20这种只f[i] = f[i-2]
00,30,40...等都是非法的。。。。
'''
class Solution:
    # @param s, a string
    # @return an integer
    def numDecodings(self, s):
        if not s: return 0
        # dp[M] means decode ways for first M letters of s
        dp = [0 for i in xrange(len(s) + 1)]
        dp[0] = 1
        dp[1] = 0 if s[0] == '0' else 1
        for i in xrange(2, len(s) + 1):
            if s[i-1] != '0': dp[i] += dp[i-1]
            if 10 <= int(s[i-2:i]) <= 26: dp[i] += dp[i-2]
        return dp[len(s)]


# Your NumArray object will be instantiated and called as such:
# numArray = NumArray(nums)
# numArray.sumRange(0, 1)
# numArray.sumRange(1, 2)

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
#
if __name__ == "__main__":
    result = Solution().numSquares(12)
    print(result)
