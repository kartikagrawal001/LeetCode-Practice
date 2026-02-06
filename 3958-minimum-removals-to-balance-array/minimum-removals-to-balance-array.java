class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int j=0;
        int maxLen= 0;
        while(j<nums.length){
            long min = nums[i];
            long max = nums[j];
            while(i<j && max>min*k){
                i++;
                min = nums[i];
            }
            maxLen = Math.max(maxLen,j-i+1);
            j++;
        }
        return nums.length-maxLen;
    }
}

