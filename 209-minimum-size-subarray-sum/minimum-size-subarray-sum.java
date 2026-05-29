class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int low = 0;
        int high = 0;
        int min  = Integer.MAX_VALUE;
        while(high<nums.length){
            sum+=nums[high];
            while(sum>=target){
                int size = high-low+1;
                min = Math.min(min,size);
                sum-=nums[low];
                low++;
            }
            high++;
        }
        if(min==Integer.MAX_VALUE)return 0;
        return min;
    }
}