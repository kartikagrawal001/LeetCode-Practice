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
    Stack<TreeNode> asc = new Stack<>();
    Stack<TreeNode> dsc = new Stack<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)return false;
        TreeNode t = root;
        while(t!=null){
            asc.push(t);
            t = t.left;
        }
        t = root;
        while(t!=null){
            dsc.push(t);
            t = t.right;
        }
        TreeNode i = getSmall();
        TreeNode j = getBig();
        while(i!=null && j!=null && i!=j && i.val<j.val ){
            int sum = i.val+j.val;
            if(sum==k)return true;
            else if(sum>k)j=getBig();
            else i = getSmall();
        }
        return false;
    }
    public TreeNode getSmall(){
        if(asc.isEmpty())return null;
        TreeNode small = asc.pop();
        TreeNode right = small.right;
        while(right!=null){
            asc.push(right);
            right = right.left;
        }
        return small;
    }
    public TreeNode getBig(){
        if(dsc.isEmpty())return null;
        TreeNode big = dsc.pop();
        TreeNode left = big.left;
        while(left!=null){
            dsc.push(left);
            left = left.right;
        }
        return big;
    }
}