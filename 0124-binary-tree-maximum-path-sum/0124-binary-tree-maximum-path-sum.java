
class Solution {
    int max = Integer.MIN_VALUE; // Ab tak ka maximum path sum store karega

    public int maxPathSum(TreeNode root) {
        gain(root); // Recursion se har node ka gain calculate karenge
        return max; // Final maximum path sum return karenge
    }

    int gain(TreeNode root) {
        if (root == null) return 0; // Null node ka koi contribution nahi

        // Left aur right subtree ka maximum gain nikalo
        int left = Math.max(0, gain(root.left));
        int right = Math.max(0, gain(root.right));

        // Current node se dono branches mila kar maximum path check karo
        max = Math.max(max, root.val + left + right);

        // Parent ko sirf ek branch ka maximum gain return kar sakte hain
        return root.val + Math.max(left, right);
    }
}