class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c:text.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        String b = "balloon";
        int count = 0;
        boolean f = true;
        while(f){
            for(char c:b.toCharArray()){
                if(map.containsKey(c)){
                    map.put(c,map.getOrDefault(c,0)-1);
                    if(map.get(c)==0)map.remove(c);
                }
                else {
                    f = false;
                }
            }
            if(f)count++;
        }
        return count;
    }
}
