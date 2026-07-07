class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String s :arr){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        int c = 0;
        for(String key:arr){
            if(map.get(key)==1){
                c++;
                if(c==k)return key;
            }
        }
        return "";
    }
}