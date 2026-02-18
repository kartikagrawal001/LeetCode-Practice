class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ways = 0;
        
        for (long pen = 0; pen * cost1 <= total; pen++) {
            long remaining = total - pen * cost1;
            ways += (remaining / cost2) + 1;
        }
        
        return ways;
    }
}