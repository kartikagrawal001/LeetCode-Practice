class Solution {
    public int longestOnes(int[] nums, int k) {
        int count0 = 0;
        int low = 0;
        int max = 0;
        for(int high = 0;high<nums.length;high++){
            if(nums[high]==0)count0++;
            while(count0>k){
                if(nums[low]==0)count0--;
                low++;
            }
            max = Math.max(high-low+1,max);
        }
        return max ;
    }
}