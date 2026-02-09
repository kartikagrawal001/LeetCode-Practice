class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 1;
        int high = nums[n-1];
        while(low<=high){
            int mid  = (low+high)/2;
            int sum = calsum(mid,nums);
            if(sum>threshold){
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return low;
    }
    public int calsum(int div,int[]nums){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]%div==0)sum+=nums[i]/div;
           else sum+=(nums[i]/div)+1;
        }
        return sum;
    }
}