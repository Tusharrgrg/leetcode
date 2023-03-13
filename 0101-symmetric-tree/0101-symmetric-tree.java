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
    public boolean isSymmetric(TreeNode root) {
        return solve(root,root);
    }
    
    public boolean solve(TreeNode left, TreeNode right){
        if (left == null || right == null)return left == right;

    return left.val == right.val && solve(left.left, right.right) && solve(left.right,right.left);
    }
}