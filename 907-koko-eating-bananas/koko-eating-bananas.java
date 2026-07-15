class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low = 1;
        int high = piles[piles.length-1];
        while(low<=high){
            int mid = (low+high)/2;
            int count  = 0;
            for(int v:piles){
                count+= Math.ceil((double)v/mid);
            }
            if(count<=h){
                high = mid-1;
            }
            else low = mid+1;
        }
        return low;
    }
}