class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1)return s;
        String ans = "";
        for(int i=1;i<s.length();i++){
            int l1 = i;
            int r1 = i;
            while(l1>=0 && r1<s.length() && s.charAt(l1)==s.charAt(r1)){
                l1--;
                r1++;
            }
            if(ans.length()<(r1-l1-1))ans = s.substring(l1+1,r1);
            int l2 = i-1;
            int r2 = i;
            while(l2>=0 && r2<s.length() && s.charAt(l2)==s.charAt(r2)){
                l2--;
                r2++;
            }
            if(ans.length()<(r2-l2-1))ans = s.substring(l2+1,r2);
        }
        return ans;
    }
}