class Solution {
    public int fib(int n) {
        if(n<=1)return n;
        int[]dp = new int[n+1];
        for(int i=0;i<=n;i++)dp[i] = -1;
        return helper(n,dp);
    }
    public int helper(int n,int[]dp) {
        if(n<=1)return n;
        if(dp[n]!=-1)return dp[n];
        int ans = helper(n-1,dp)+helper(n-2,dp);
        dp[n]=ans;
        return ans;
    }

}