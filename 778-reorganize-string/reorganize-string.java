class Pair{
    int first;
    char second;
    Pair(int f,char c){
        first = f;
        second = c;
    }
}
class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        Queue<Pair> pq = new PriorityQueue<>(
            (a,b)->b.first-a.first
        );
        for(char key:map.keySet()){
            pq.offer(new Pair(map.get(key),key));
        }
        String res = "";
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(res.length()==0||res.charAt(res.length()-1)!=p.second){
                res+=p.second;
                p.first--;
                if(p.first>0)pq.offer(p);
            }
            else{
                if(pq.isEmpty())return "";
                Pair p2 = pq.poll();
                res+=p2.second;
                p2.first--;
                if(p2.first>0)pq.offer(p2);
                pq.offer(p);
            }
        }
        return res;
    }
}