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
    List<TreeNode> list = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        if(root==null)return;
        inorder(root);
        TreeNode g1first = null;
        TreeNode g1sec= null;
        TreeNode g2first = null;
        TreeNode g2sec = null;
        int g = 0;
        for(int i=1;i<list.size();i++){
            if(list.get(i).val<=list.get(i-1).val){
                if(g==0){
                    g1first = list.get(i-1);
                    g1sec = list.get(i);
                }
                else{
                    g2first = list.get(i-1);
                    g2sec = list.get(i);
                }
                g++;
            }
        }
        if(g==1){
            int temp = g1first.val;
            g1first.val = g1sec.val;
            g1sec.val = temp;
        }
        else{
            int temp = g1first.val;
            g1first.val = g2sec.val;
            g2sec.val = temp;
        }
    }
    public void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}