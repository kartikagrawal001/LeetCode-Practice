class Solution {
    public boolean ispossible(int[]candies,long k,int guess){
        long count = 0;
        for(int v:candies){
            count+= v/guess;
        }
        if(count>=k)return true;
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int v:candies){
            high = Math.max(v,high);
        }
        int ans = 0;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(ispossible(candies,k,mid)){
                ans = mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        return ans;
    }
}