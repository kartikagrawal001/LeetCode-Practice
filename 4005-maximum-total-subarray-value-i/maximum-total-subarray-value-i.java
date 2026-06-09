class Solution {
    public long maxTotalValue(int[] nums, int k) {
        Arrays.sort(nums);
        int min  = nums[0];
        int max = nums[nums.length-1];
        long diff = max-min;
        return diff*k;
    }
}