class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,ArrayList<String>> map= new HashMap<>();
        for(String s:strs){
            char[]arr = s.toCharArray();
            Arrays.sort(arr);
            String st = new String(arr);
            if(map.containsKey(st))map.get(st).add(s);
            else{
                map.put(st,map.getOrDefault(st, new ArrayList<>()));
                map.get(st).add(s);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key:map.keySet()){
            ans.add(new ArrayList<>(map.get(key)));
        }
        return ans;
    }
}