class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        int rem = targetSum - root.val;

        if (root.left == null && root.right == null) {
            return rem == 0;
        }

        return hasPathSum(root.left, rem)
            || hasPathSum(root.right, rem);
    }
}