class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int j=0;
        int maxLen= 0;
        while(i<nums.length && j<nums.length && i<=j){
            if((long)nums[j]<= (long)nums[i]*k){
                maxLen = Math.max(maxLen,j-i+1);
                j++;
            }
            else i++;
        }
        return nums.length-maxLen;
    }
}

