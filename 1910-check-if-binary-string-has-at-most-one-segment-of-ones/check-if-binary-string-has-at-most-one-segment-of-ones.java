class Solution {
    public boolean checkOnesSegment(String s) {
        boolean f1 = false;
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1' && !f1){
                f1 = true;
                count++;
            }
            else if(s.charAt(i)=='0') f1 = false;
        }
        return count<=1;
    }
}