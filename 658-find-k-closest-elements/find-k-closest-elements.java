class Pair{
    int first;
    int second;
    Pair(int dist,int idx){
        first = dist;
        second = idx;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<Pair> pq = new PriorityQueue<>(
            (a,b)->b.first-a.first
        );
        for(int i=0;i<k;i++){
            int diff = Math.abs(arr[i]-x);
            pq.offer(new Pair(diff,i));
        }
        for(int i=k;i<arr.length;i++){
            int diff = Math.abs(arr[i]-x);
            if(pq.peek().first<=diff)continue;
            pq.poll();
            pq.offer(new Pair(diff,i));
        }
        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(arr[pq.peek().second]);
            pq.poll();
        }
        Collections.sort(list);
        return list;
    }
}
