class Solution {
    public boolean predictTheWinner(int[] nums) {
        return find(0,nums.length-1,nums)>=0;

    }
    public int find(int start,int end,int[] nums){
        if (start==end) {
            return nums[start];
        }
        int pre=nums[start];
        int a=pre-find(start+1,end,nums);
        int last = nums[end];
        int b=last-find(start,end-1,nums);
        return Math.max(a,b);
    }
}