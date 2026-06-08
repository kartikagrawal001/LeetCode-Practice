class Solution {
    public int totalFruit(int[] fruits) {
        int low = 0;
        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int high = 0;high<fruits.length;high++){
            map.put(fruits[high],map.getOrDefault(fruits[high],0)+1);
            while(map.size()>2){
                int v = fruits[low];
                map.put(v,map.getOrDefault(v,0)-1);
                if(map.get(v)==0)map.remove(v);
                low++;
            }
            max = Math.max(high-low+1,max);
        }
        return max;  
    }
}