# coding=utf-8
'''
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
'''
import collections
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
方法一：O(m + n) 线性搜索

从右上角开始, 比较target 和 matrix[i][j]的值. 如果小于target, 则该行不可能有此数,  所以i++;

如果大于target, 则该列不可能有此数, 所以j--. 遇到边界则表明该矩阵不含targe
'''


class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return False
        i = 0
        j = len(matrix[0]) - 1
        while i < len(matrix) and j >= 0:
            if matrix[i][j] == target:
                return True
            elif matrix[i][j] > target:
                j -= 1
            else:
                i += 1
        return False


'''
方法二： 二分查找 O( m * log(n))

遍历每一行，每一行进行二分查找相应的列
'''
class Solution:
    # @param {integer[][]} matrix
    # @param {integer} target
    # @return {boolean}
    def searchMatrix(self, matrix, target):
        y = len(matrix[0]) - 1
        def binSearch(nums, low, high):
            while low <= high:
                mid = (low + high) / 2
                if nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return high
        for x in range(len(matrix)):
            y = binSearch(matrix[x], 0, y)
            if matrix[x][y] == target:
                return True
        return False

