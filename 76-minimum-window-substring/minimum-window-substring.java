class Solution {
    public boolean matched(HashMap<Character,Integer> map1,HashMap<Character,Integer> map2){
        for (Character key : map1.keySet()) {
            if (map2.getOrDefault(key, 0) < map1.get(key)) {
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        HashMap<Character,Integer> map1 = new HashMap<>();
        for(char ch:t.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> map2 = new HashMap<>();
        String ans = "";
        for(int high = 0;high<s.length();high++){
            char c = s.charAt(high);
            map2.put(c,map2.getOrDefault(c,0)+1);
            while(matched(map1,map2)){
                int l = high-low+1;
                if(l<min){
                    min = Math.min(min,l);
                    ans = s.substring(low,high+1);
                }
                char ch = s.charAt(low);
                map2.put(ch,map2.getOrDefault(ch,0)-1);
                low++;
            }
        }
        return ans;
    }
}