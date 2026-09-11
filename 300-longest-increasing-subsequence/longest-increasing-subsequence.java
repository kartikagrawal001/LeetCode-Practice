class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][]dp = new int[nums.length+1][nums.length+1];
        for(int i[]:dp)Arrays.fill(i,-1);
        return helper(0,-1,nums,dp);
    }
    public int helper(int i, int prevIdx,int[]nums,int[][]dp){
        if(i==nums.length)return 0;
        if(dp[i][prevIdx+1]!=-1)return dp[i][prevIdx+1];
        int take = 0;
        if(prevIdx==-1 || nums[i]>nums[prevIdx] ){
            take = 1 + helper(i+1,i,nums,dp);
        }
        int skip = helper(i+1,prevIdx,nums,dp);
        return dp[i][prevIdx+1]= Math.max(take,skip);
    }
}