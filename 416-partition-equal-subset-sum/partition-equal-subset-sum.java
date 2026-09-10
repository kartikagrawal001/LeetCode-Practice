class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int v : nums) total += v;
        if (total % 2 != 0) return false;
        int target = total / 2;
        boolean dp[][] = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int sum = 1; sum <= target; sum++) {
                if (nums[i] > sum)
                    dp[i][sum] = dp[i + 1][sum];

                else {
                    boolean take = dp[i + 1][sum - nums[i]];
                    boolean skip = dp[i + 1][sum];

                    dp[i][sum] = take || skip;
                }
            }
        }
        return dp[0][target];
    }
}