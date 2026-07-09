class Solution {
    public int longestOnes(int[] nums, int k){
        int low = 0;
        int max = 0;
        int count0 = 0;
        int count1 = 0;  
        for(int high = 0;high<nums.length;high++){
            if(nums[high]==1)count1++;
            else count0++;
            while(count0>k){
                int v2 = nums[low];
                if(v2==0)count0--;
                else count1--;
                low++;
            }
            max = Math.max(high-low+1,max);
        }
        return max;
    }
}