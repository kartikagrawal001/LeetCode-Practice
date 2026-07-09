class Solution {
    public int maxScore(int[] cp, int k) {
        int lsum = 0;
        for(int i=0;i<k;i++){
            lsum+=cp[i];
        }
        int l = k-1;
        int r = cp.length-1;
        int rsum = 0;
        int poss = cp.length-k;
        int maxsum  = lsum;
        while(r>=poss){
            lsum-=cp[l];
            l--;
            rsum+=cp[r];
            r--;
            maxsum = Math.max(maxsum,lsum+rsum);
        }
        return maxsum;
    }
}