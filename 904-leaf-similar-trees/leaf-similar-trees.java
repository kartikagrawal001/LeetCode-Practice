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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null||root2==null)return false;
        ArrayList<TreeNode> l1 = new ArrayList<>();
        ArrayList<TreeNode> l2 = new ArrayList<>();
        inorder(root1,l1);
        inorder(root2,l2);
        if(l1.size()!=l2.size())return false;
        for(int i=0;i<l1.size();i++){
            if(l1.get(i).val != l2.get(i).val)return false;
        }
        return true;
    }
    public void inorder(TreeNode root,ArrayList<TreeNode> ls){
        if(root==null)return;
        inorder(root.left,ls);
        if(root.left==null && root.right==null)ls.add(root);
        inorder(root.right,ls);
    }
}