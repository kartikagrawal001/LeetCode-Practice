class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer> map =  new HashMap<>();
        int low = 0;
        int ans = 0;
        for(int high = 0;high<s.length();high++){
            char ch = s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch)>2){
                while(map.get(ch)>2){
                    char ch2 = s.charAt(low);
                    low++;
                    map.put(ch2,map.getOrDefault(ch2,0)-1);
                    if(map.get(ch2)==0)map.remove(ch2);

                }
            }
            ans = Math.max(ans,high-low+1);
        }
        return ans;
    }
}