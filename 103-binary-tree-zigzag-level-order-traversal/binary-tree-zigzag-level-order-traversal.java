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
        int lev = 0;
        while(!q.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            int levelsize = q.size();
            for(int i=0;i<levelsize;i++){
                if(q.peek().left!=null)q.add(q.peek().left);
                if(q.peek().right!=null)q.add(q.peek().right);
                if(lev%2==0)list.add(q.peek().val);
                else list.addFirst(q.peek().val);
                q.poll();
            }
            lev++;
            ans.add(list);
        }
        return ans;
    }
}