class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<nums.length-2;i++){
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==target)return  sum;
                int diff = Math.abs(sum-target);
                if(diff<min){
                    min = diff;
                    ans = sum;
                }
                if(sum<target)l++;
                else r--;
            }
        }
        return ans; 
    }
}