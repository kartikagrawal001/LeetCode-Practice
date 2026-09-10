class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String,Integer> dp = new HashMap<>();
        return helper(0,0,nums,target,dp);
    }
    public int helper(int i,int sum,int [] nums,int target,Map<String,Integer>dp){
        if(i==nums.length)return sum==target ? 1 : 0;
        String key = i + "_" + sum;
        if(dp.containsKey(key))return dp.get(key);
        int plus = helper(i+1,sum+nums[i],nums,target,dp);
        int minus =  helper(i+1,sum-nums[i],nums,target,dp);
        dp.put(key,plus+minus);
        return plus + minus;
    }
}