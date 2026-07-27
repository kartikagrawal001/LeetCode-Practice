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
        if(root==null)return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<TreeNode>list = new ArrayList<>();
            int lev = q.size();
            for(int i=0;i<lev;i++){
                TreeNode curr = q.poll();
                if(curr!=null){
                    q.add(curr.left);
                    q.add(curr.right);
                }
                list.add(curr);
            }
            int i=0;
            int j=list.size()-1;
            while(i<j){
                TreeNode l = list.get(i);
                TreeNode r = list.get(j);
                if(l==null && r==null){
                    i++;
                    j--;
                    continue;
                }
                if(l==null || r==null)return false;
                if(l.val!=r.val)return false;
                i++;
                j--;
            }
        }
        return true;
    }
}