/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // Given a binary tree, find its minimum depth.
// The minimum depth is the number of nodes along the shortest 
// path from the root node down to the nearest leaf node.
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        // The node MUST be a leaf node to be valid. Thus we can't count
        // +1 if the pointer is pointing to null. Simply find the min
        // depth of the path that isn't null.
        if (root.right == null) return 1 + minDepth(root.left);
        if (root.left == null) return 1 + minDepth(root.right);

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}