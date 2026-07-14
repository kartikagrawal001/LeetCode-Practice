class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int max = piles[piles.length-1];
        int s = 1;
        int e = max;
        int ans =0;
        while(s<=e){
            int perhour = 0;
            int mid = (s+e)/2;
            for(int v:piles){
                perhour+=Math.ceil((double)v/mid);
            }
            if(perhour<=h){
                ans  = mid;
                e=mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return ans;
    }
}