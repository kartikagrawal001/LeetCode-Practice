class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        int idx = 1;
        for(char ch:s.toCharArray()){
            int d = ('z'-ch+1)*idx;
            sum+=d;
            idx++;
        }
        return sum;
    }
}