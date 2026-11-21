class Solution {
    int diameter = 0; // Sabse lamba path (in edges) store karne ke liye

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    int height(TreeNode root) {
        // Empty node ki height 0 hoti hai
        if (root == null) {
            return 0;
        }

        // Left aur right subtrees ki height nikalo
        int left = height(root.left);
        int right = height(root.right);

        // Is node se banne wala max path check karke global diameter update karo
        diameter = Math.max(diameter, left + right);

        // Upar parent ko sirf ek side ka max height return karte hain
        return 1 + Math.max(left, right);
    }
}