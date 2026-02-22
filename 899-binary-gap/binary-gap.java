class Solution {
    public int binaryGap(int n) {
        String bin = Integer.toBinaryString(n);
        int max = 0;
        int count = 0;
        boolean f = false;
        for(char c:bin.toCharArray()){
            if(c=='1'){
                if(f)max = Math.max(count+1,max);
                f = true;
                count = 0;
            }
            else if(f) count++;
        }
        return max;
    }
}