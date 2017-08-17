/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // There is also an iterative solution to this that involves using a stack. 
 // See if you can come up with that one.
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }

    public static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        // If one of them is null, then the other needs to be also, otherwise
        // the tree is not symmetric.
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;

        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
}