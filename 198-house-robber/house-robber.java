class Solution {
    public int rob(int[] nums) {
        int[][]dp = new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        int free = 1;
        return helper(0,free,nums,dp); 
    }
    public int helper(int i,int free,int[]nums,int[][]dp){
        if(i==nums.length)return 0;
        if(dp[i][free]!=-1)return dp[i][free];
        if(free==0)return helper(i+1,1,nums,dp);
        int c1 = nums[i] + helper(i+1,0,nums,dp);
        int c2 = helper(i+1,1,nums,dp);
        return dp[i][free] = Math.max(c1,c2);
    }
}