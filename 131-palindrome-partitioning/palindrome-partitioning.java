class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(0,s.length(),s,new ArrayList<String>(),ans);
        return ans;
    }
    public void helper(int idx,int n,String s,List<String> ds,List<List<String>> ans){
        if(idx>=n){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=idx+1;i<=n;i++){
            if(ispalindrome(s.substring(idx,i))){
                ds.add(s.substring(idx,i));
                helper(i,n,s,ds,ans);
                ds.remove(ds.size()-1);
            }
        }
    }
    public boolean ispalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString().equals(s);
    }
}