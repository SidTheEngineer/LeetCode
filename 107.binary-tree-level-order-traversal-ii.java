/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// The trick here is to use a queue with a DFS approach to the problem (could also do BFS).
 public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> results = new LinkedList<List<Integer>>();

        if (root == null) return results;

        q.offer(root);
        while (!q.isEmpty()) {
            int currentLevel = q.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < currentLevel; i++) {
                // If there are more nodes for us to check at the current level, add them to the queue.
                if (q.peek().left != null) q.offer(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);

                // Add the current root node val
                subList.add(q.poll().val);
            }

            // By inserting at the front of the list instead of appending, our list will end up
            // as a bottom-up left to right representation of the tree.
            results.add(0, subList);
        }

        return results;
    }
}