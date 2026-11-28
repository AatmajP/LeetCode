/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Agar main tree (root) hi null hai, toh subRoot mil hi nahi sakta
        if (root == null) {
            return false;
        }

        // Check karo ki kya current root se hi exact same tree (subRoot) start ho raha hai
        if (issame(root, subRoot)) {
            return true;
        }

        // Warna left ya right subtree mein aage jaakar isSubtree check karo
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    boolean issame(TreeNode left, TreeNode right) {
        // Dono nodes null hain, matlab is branch par dono identical hain
        if (left == null && right == null) {
            return true;
        }

        // Ek null hai aur dusra nahi, toh match nahi karega
        if (left == null || right == null) {
            return false;
        }

        // Values same nahi hain toh false
        if (left.val != right.val) {
            return false;
        }

        // Left aur right dono bacchon (children) ko same helper method se check karo
        return issame(left.left, right.left) && issame(left.right, right.right);
    }
}