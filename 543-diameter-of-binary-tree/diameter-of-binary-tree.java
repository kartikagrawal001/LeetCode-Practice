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
    public int height(TreeNode root){
        if(root==null)return 0;
        int l = 1 + height(root.left);
        int r = 1 + height(root.right);
        return Math.max(l,r);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int d1 = diameterOfBinaryTree(root.left);
        int d2 = diameterOfBinaryTree(root.right);
        int curr = height(root.left) + height(root.right);
        return Math.max(curr,Math.max(d1,d2));
    }
}