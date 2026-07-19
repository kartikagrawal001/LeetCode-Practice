class Pair{
    int first;
    int second;
    Pair(int f,int el){
        first = f;
        second = el;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int v:nums){
            map.put(v,map.getOrDefault(v,0)+1);
        }
        Queue<Pair> pq = new PriorityQueue<>(
            (a,b)->{ return a.first-b.first; }
        );
        for(int key:map.keySet()){
            int val = map.get(key);
            if(pq.size()<k)pq.offer(new Pair(val,key));
            else{
                if(val>pq.peek().first){
                    pq.poll();
                    pq.offer(new Pair(val,key));
                }
            }
        }
        int[] ans = new int[k];
        int idx = 0; 
        while(!pq.isEmpty()){
            ans[idx++] = pq.poll().second;
        }
        return ans;
    }
}