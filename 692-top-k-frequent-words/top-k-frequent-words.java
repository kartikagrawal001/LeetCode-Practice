class Pair{
    int first;
    String second;
    Pair(int f , String s){
        first = f;
        second = s;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String st:words){
            map.put(st,map.getOrDefault(st,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.first!=b.first)return a.first-b.first;
                return b.second.compareTo(a.second);
            }
        );
        for(String key:map.keySet()){
            int freq = map.get(key);
            if(pq.size()<k)pq.offer(new Pair(freq,key));
            else{
                Pair top = pq.peek();
                if(top.first<freq|| top.first==freq && key.compareTo(top.second)<0){
                    pq.poll();
                    pq.offer(new Pair(freq,key));
                }
            }
        }
        List<String> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll().second);
        }
        Collections.reverse(list);
        return list;
    }
}