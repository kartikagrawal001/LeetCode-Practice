class Solution {
    public boolean doesAliceWin(String s) {
        int c= 0;
        String vow = "AEIOUaeiou";
        for(char v:s.toCharArray()){
            if(vow.contains(String.valueOf(v))){
                c+=1;
                break;
            }
        }
        return c>0;
    }
}