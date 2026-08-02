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
    int currsum= 0;
    ArrayList<Integer> ans = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        helper(root);
        int sum = 0;
        for(int v:ans)sum+=v;
        return sum;
    }
    public void helper(TreeNode root){
        if(root==null)return;
        currsum = currsum * 10 + root.val;
        if(root.left==null && root.right==null){
            ans.add(currsum);
            currsum /= 10;
            return;
        }
        helper(root.left);
        helper(root.right);
        currsum /= 10;
    }
}