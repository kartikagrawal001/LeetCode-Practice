class Solution {
    public int numberOfSubstrings(String s) {
      Map<Character,Integer> map = new HashMap<>();
      int n = s.length();
      int low = 0;
      int count = 0;
      for(int high = 0;high<n;high++){
        char ch = s.charAt(high);
        map.put(ch,map.getOrDefault(ch,0)+1);
        while(map.size()==3){
            count= count+(n-high);
            char ch2 = s.charAt(low);
            map.put(ch2,map.getOrDefault(ch2,0)-1);
            low++;
            if(map.get(ch2)==0)map.remove(ch2);
        }
      } 
      return count;
    }
}