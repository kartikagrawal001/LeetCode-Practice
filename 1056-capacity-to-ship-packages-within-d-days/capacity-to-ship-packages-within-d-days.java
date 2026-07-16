class Solution {
    public boolean possible(int[]weights,int days, int guess){
        int temp = guess;
        int count = 1;
        for(int v:weights){
            if(v<=temp) temp-=v;

            else{
                count++;
                temp = guess;
                temp-=v;
            }
        }
        if(count<=days)return true;
        return false;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        int ans = 1;
        for(int v:weights){
            low = Math.max(low,v);
            high +=v;
        }
        while(low<=high){
            int mid = (low+high)/2;
            if(possible(weights,days,mid)){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
}