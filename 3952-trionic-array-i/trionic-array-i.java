class Solution {
    public boolean isTrionic(int[] nums) {
        boolean start = false;
        boolean mid = false;
        boolean end = false;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1] && !mid && !end){
                start=true;
            }  
            else if(nums[i]>nums[i+1] && start && !end){
                mid=true;
            }
            else if(nums[i]<nums[i+1] && start && mid){
                end = true;
            }
            else return false;
        }
        return start && mid && end;
    }
}