/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note: Given target value is a floating point. You are guaranteed to have only one unique value in the BST that is closest to the target.
*/


/* �ݹ鷨

���Ӷ�

ʱ�� O(logN) �ռ� O(H)

˼·

���ݶ����������ʣ�����֪����������ĳ�����ڵ�ʱ��������Ǹ��ڵ�Ҫô�����������棬Ҫô���Ǹ��ڵ㱾��

�������Ǹ�������ݹ飬��������������Ľڵ㣬�͸��ڵ��и������Ǹ������ˡ�

����
*/

public class Solution {
    public int closestValue(TreeNode root, double target) {
        // ѡ�������ĸ��ڵ�
        TreeNode kid = target < root.val ? root.left : root.right;
        // ���û��������Ҳ���ǵݹ鵽��ʱ��ֱ�ӷ��ص�ǰ�ڵ�ֵ
        if(kid == null) return root.val;
        // �ҳ�������������Ǹ��ڵ�
        int closest = closestValue(kid, target);
        // ���ظ��ڵ����������ڵ��У��������Ǹ��ڵ�
        return Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
    }
}



/* ������

���Ӷ�

ʱ�� O(logN) �ռ� O(H)

˼·

��¼һ�������ֵ��Ȼ�����Ŷ���������·��һ·�Ƚ���ȥ��������������ֵ�����ˡ�

��Ϊ����֪����Ŀ������ӽ������϶��ڶ���������·���ϡ�

����*/

public class Solution {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while(root != null){

            // ��������
            root = target < root.val ? root.left : root.right;
			
			// ����ýڵ����Ŀ�����������µ�ĿǰΪֹ�����ֵ
            closest = Math.abs(closest - target) < Math.abs(root.val - target) ? closest : root.val;
        }
        return closest;
    }
}