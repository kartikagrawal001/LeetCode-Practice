class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-","").toUpperCase();
        StringBuilder sb = new StringBuilder(s);

        int count = 0;
        for(int i=s.length()-1;i>0;i--){
            count++;
            if(count==k){
                sb.insert(i,'-');
                count=0;
            }
        }
        return sb.toString();
    }
}