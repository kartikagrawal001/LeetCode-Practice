class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int minsum = 0;
        int maxsum  = 0;
        int currminsum = 0;
        int currmaxsum = 0;
        for(int v:nums){
            currmaxsum = Math.max(currmaxsum+v,v);
            maxsum = Math.max(maxsum,currmaxsum);
            currminsum = Math.min(currminsum+v,v);
            minsum = Math.min(minsum,currminsum);
        }
        return Math.max(maxsum,Math.abs(minsum));
    }
}