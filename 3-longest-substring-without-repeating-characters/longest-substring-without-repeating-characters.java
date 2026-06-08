class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        int maxLen = 0;
        Map<Character , Integer> map = new HashMap<>();
        for(int high = 0;high<s.length();high++){
            char ch = s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0)+1);
            int k = high-low+1;
            if(map.size()<k){
                char ch2 = s.charAt(low);
                map.put(ch2,map.getOrDefault(ch2,0)-1);
                if(map.get(ch2)==0)map.remove(ch2);
                low++;
                k = high-low-1;
            }
            if(map.size()==k)maxLen = Math.max(k,maxLen);
        }
        return maxLen;
    }
}