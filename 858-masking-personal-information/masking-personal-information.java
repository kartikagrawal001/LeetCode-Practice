class Solution {
    public String maskPII(String s) {
        String country[] = {"","+*-","+**-","+***-"};
        int idx = s.indexOf('@');
        if(idx!=-1){
            return (s.charAt(0)+"*****"+s.substring(idx-1)).toLowerCase();
        }
        s = s.replaceAll("[^0-9]","");
        return country[s.length()-10]+"***-***-"+s.substring(s.length()-4);
     }
}