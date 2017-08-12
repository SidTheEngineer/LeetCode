/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        // We have reached a leaf node.
        if (root.left == null && root.right == null) return root.val == sum;

        int newSum = sum - root.val;

        if (root.left == null) return hasPathSum(root.right, newSum);
        if (root.right == null) return hasPathSum(root.left, newSum);

        return hasPathSum(root.left, newSum) || hasPathSum(root.right, newSum);
    }
}