class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int v:stones) pq.offer(v);
        while(pq.size()>1){
            int y = pq.poll();
            int x = pq.poll();
            if(x==y) continue;
            else pq.offer(y-x);
        }
        if(pq.size()==1)return pq.poll();
        return 0;
    }
}