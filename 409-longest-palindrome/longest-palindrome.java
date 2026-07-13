class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int odd = 0;
        int evensum = 0;
        for(char v:map.keySet()){
            if(map.get(v) % 2 == 0)evensum+=map.get(v);
            else {
                odd = 1;
                evensum+= (map.get(v)-1);
            }
        }
        return odd + evensum;
    }
}