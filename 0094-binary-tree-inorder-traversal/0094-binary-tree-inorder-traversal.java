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
    public void inOrder(TreeNode curr, List<Integer> res){

        if(curr==null) return ;
        
        inOrder(curr.left,res);
        res.add (curr.val);
        inOrder(curr.right,res);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        inOrder(root,res);
        return res;
        
    }
}