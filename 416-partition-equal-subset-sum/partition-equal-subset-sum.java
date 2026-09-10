class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int v:nums)total+=v;
        if(total%2!=0)return false;
        Boolean dp[][] = new Boolean[nums.length][total+1];
        return helper(0,total/2,nums,dp);
    }
    public boolean helper(int i,int sum,int[]nums,Boolean dp[][]){
        if(i==nums.length){
            if(sum==0)return true;
            else return false;
        }
        if(dp[i][sum]!=null)return dp[i][sum];
        if(nums[i]>sum)return dp[i][sum] = helper(i+1,sum,nums,dp);
        boolean take = helper(i+1,sum-nums[i],nums,dp);
        boolean skip = helper(i+1,sum,nums,dp);
        return dp[i][sum] = take||skip;

    }
}