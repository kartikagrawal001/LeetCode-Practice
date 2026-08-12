class Solution {
    public int climbStairs(int n) {
        if(n==1||n==2)return n;
        int[]dp = new int[n+1];
        for(int i=0;i<=n;i++)dp[i] = -1;
        return helper(n,dp);
    }
    public int helper(int n,int[]dp){
        if(n==1||n==2)return n;
        if(dp[n]!=-1)return dp[n];
        int prev1 = helper(n-1,dp);
        int prev2 = helper(n-2,dp);
        return dp[n] = prev1 + prev2;
    }
}