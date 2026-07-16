class Solution {
    public boolean ispossible(int[]nums,int k, int guess){
        int count = 1;
        int sum = guess;
        for(int v:nums){
            if(v<=sum)sum-=v;
            else{
                count++;
                sum = guess;
                sum-=v;
            }
        }
        if(count<=k)return true;
        return false;
    }
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int v:nums){
            low = Math.max(v,low);
            high+=v;
        }
        int ans = high;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(ispossible(nums,k,mid)){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
}