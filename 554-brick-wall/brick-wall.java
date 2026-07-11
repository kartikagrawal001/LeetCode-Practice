class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map = new HashMap<>();
        for(List<Integer> list:wall){
            int sum = 0;
            for(int i=0;i<list.size()-1;i++){
                sum+=list.get(i);
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        int maxf = 0;
        for(int key:map.keySet()){
            if(map.get(key)>maxf){
                maxf = map.get(key);
            }
        }
        return wall.size()-maxf;
    }
}