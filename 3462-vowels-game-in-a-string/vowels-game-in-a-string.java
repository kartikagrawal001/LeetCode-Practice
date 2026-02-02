class Solution {
    public boolean doesAliceWin(String s) {
        for(char v:s.toCharArray()){
            if(v=='a'||v=='e'||v=='i'||v=='o'||v=='u')return true;
        }
        return false;
    }
}