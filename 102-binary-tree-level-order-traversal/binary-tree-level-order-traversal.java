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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int lvl = q.size();
            List<Integer> lst = new ArrayList<>();
            for(int i=0;i<lvl;i++){
                TreeNode temp = q.poll();
                lst.add(temp.val);
                if(temp!= null && temp.left!=null)q.offer(temp.left);
                if(temp!= null && temp.right!=null)q.offer(temp.right);
            }
            ans.add(new ArrayList<>(lst));
        }
        return ans;
    }
}