class Pair{
    int first;
    int second;
    Pair(int dist,int idx){
        first = dist;
        second = idx;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Pair> pq = new PriorityQueue<>(
            (a,b)->b.first-a.first
        );
        for(int r = 0;r<k;r++){
            int x = points[r][0];
            int y = points[r][1];
            int dis = (x*x) + (y*y);
            pq.offer(new Pair(dis,r));
        }
        for(int r=k;r<points.length;r++){
            int x = points[r][0];
            int y = points[r][1];
            int dis = (x*x) + (y*y);
            if(pq.peek().first<=dis)continue;
            pq.poll();
            pq.offer(new Pair(dis,r));
        }
        int[][]ans = new int[pq.size()][2];
        int i = 0;
        while(!pq.isEmpty()){
            ans[i][0] = points[pq.peek().second][0];
            ans[i][1] = points[pq.peek().second][1];
            pq.poll();
            i++;
        }
        return ans;
    }
}