class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:text.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);
        if(map.containsKey('l'))map.put('l',map.getOrDefault('l',0)/2);
        if(map.containsKey('o'))map.put('o',map.getOrDefault('o',0)/2);
        String b = "balon";
        int min = Integer.MAX_VALUE;
        for(char ch:b.toCharArray()){
            if(map.containsKey(ch))min = Math.min(min,map.get(ch));
            else return 0;
        }
        return min;
    }
}
