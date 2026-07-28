class Solution {
    public String smallestPalindrome(String s) {
        if(s.length()==1)return s;
        int w = s.length()/2;
        String half = s.substring(0,w);
        char[]arr = half.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(char c:arr){
            sb.append(c);
        }
        StringBuilder save = new StringBuilder(sb);
        if(s.length()%2!=0)sb.append(s.charAt(w)).append(save.reverse());
        else sb.append(save.reverse());
        return sb.toString();
    }
}