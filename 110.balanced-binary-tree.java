import javax.swing.text.AbstractDocument.LeafElement;

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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftTreeDepth = findDepth(root.left);
        int rightTreeDepth = findDepth(root.right);

        // Out difference in the heights of the left and right subtrees can be no larger
        // than 1 for a balanced height tree.
        return Math.abs(leftTreeDepth - rightTreeDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    // This method finds the max depth of a tree given its root. This was a previous problem!
    public static int findDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(findDepth(root.left), findDepth(root.right));
    }
}