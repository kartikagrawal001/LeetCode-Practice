class Solution {
    public int minimumCost(int[] nums) {
        int cost=nums[0];
        nums[0]=Integer.MAX_VALUE;
        Arrays.sort(nums);
        cost+=nums[0];
        cost+=nums[1];
        return cost;
    }
}