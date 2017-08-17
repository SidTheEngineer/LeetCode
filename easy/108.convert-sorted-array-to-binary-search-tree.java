/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// The trick here is converting the sorted array (inorder traversal) to preorder traversal (root -> left -> right)
// by dividing and conquering the array. It's easy going from BST -> array, however this is a bit different in that
// we need to go array -> BST.
 public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        return helper(nums, 0, nums.length - 1);
    }

    public static TreeNode helper(int[] nums, int lo, int hi) {
        if (lo > hi) return null;

        int mid = (lo + hi) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, lo, mid - 1);
        node.right = helper(nums, mid + 1, hi);
        return node;
    }
}