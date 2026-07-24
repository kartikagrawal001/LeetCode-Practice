class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n,0,0,sb,ans);
        return ans;
    }
    public void helper(int n, int open,int close,StringBuilder temp,List<String> ans){
        if(open==n && close==n){
            ans.add(temp.toString());
            return;
        }
        if(open<n){
            temp.append('(');
            helper(n,open+1,close,temp,ans);
            temp.deleteCharAt(temp.length()-1);
        }
        if(close<open){
            temp.append(')');
            helper(n,open,close+1,temp,ans);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}