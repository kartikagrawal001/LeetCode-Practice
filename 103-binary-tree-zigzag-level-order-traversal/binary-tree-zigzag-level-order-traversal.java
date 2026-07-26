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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)return ans;
        q.offer(root);
        boolean f = true;
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int levelsize = q.size();
            for(int i=0;i<levelsize;i++){
                if(q.peek().left!=null)q.add(q.peek().left);
                if(q.peek().right!=null)q.add(q.peek().right);
                list.add(q.peek().val);
                q.poll();
            }
            if(f){
                ans.add(list);
                f = false;
            }
            else {
                Collections.reverse(list);
                ans.add(list);
                f = true;
            }
        }
        return ans;
    }
}