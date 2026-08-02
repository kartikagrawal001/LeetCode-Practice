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
    int sum = 0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(root,targetSum,ans,ds);
        return ans;
    }
    public void helper(TreeNode root, int target,List<List<Integer>> ans,List<Integer> ds){
        if(root==null)return;
        sum+=root.val;
        ds.add(root.val);
        if(root.left==null && root.right==null && sum==target){
            ans.add(new ArrayList<>(ds));
        }
        helper(root.left,target,ans,ds);
        helper(root.right,target,ans,ds);
        ds.remove(ds.size()-1);
        sum-=root.val;
    }

}