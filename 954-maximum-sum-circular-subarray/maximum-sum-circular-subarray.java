class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int bestmax = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            bestmax = Math.max(bestmax+nums[i],nums[i]);
            max = Math.max(max,bestmax);
        }
        int bestmin = nums[0];
        int min = nums[0];
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            bestmin = Math.min(bestmin+nums[i],nums[i]);
            min = Math.min(bestmin,min);
        }
        if(max<0)return max;
        return Math.max(max,sum-min);
    }
}