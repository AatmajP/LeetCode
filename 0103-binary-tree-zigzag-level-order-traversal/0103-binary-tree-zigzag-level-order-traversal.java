/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() { }
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // Agar tree hi khali hai toh seedha empty list return kar do
        if (root == null) {
            return result;
        }

        // BFS ke liye queue use kar rahe hain
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Pehla level (root) left-to-right jayega
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size(); // Current level mein kitne nodes hain
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);

                // Queue mein normal BFS order (left -> right) mein hi children daalenge
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            // Agar right-to-left chahiye tha, toh is level ki list reverse kar do
            if (!leftToRight) {
                Collections.reverse(level);
            }

            result.add(level);
            leftToRight = !leftToRight; // Agle level ke liye direction flip kar do
        }

        return result;
    }
}