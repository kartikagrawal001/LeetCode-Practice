class Solution {
    public boolean possible(int[]bloomDay,int m,int k,int guess){
        int countK = 0;
        int bouq = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=guess){
                countK++;
            }
            else countK = 0;
            if(countK==k){
                bouq++;
                countK = 0;
            }
            if(bouq==m)return true;
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length)return -1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int v:bloomDay){
            low = Math.min(v,low);
            high = Math.max(v,high);
        }
        while(low<=high){
            int mid = (low+high)/2;
            if(possible(bloomDay,m,k,mid))high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}