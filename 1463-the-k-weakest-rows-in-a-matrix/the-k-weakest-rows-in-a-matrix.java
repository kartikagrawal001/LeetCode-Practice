class Pair{
    int first;
    int second;
    Pair(int dist,int idx){
        first = dist;
        second = idx;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Queue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.first!=b.first)return b.first-a.first;
                return b.second-a.second;
            }
        );
        for(int i=0;i<k;i++){
            int count1 = 0;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==1)count1++;
            }
            pq.offer(new Pair(count1,i));
        }
        for(int i=k;i<mat.length;i++){
            int count1 = 0;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==1)count1++;
            }
            if(pq.peek().first<=count1)continue;
            pq.poll();
            pq.offer(new Pair(count1,i));
        }
        int ans[] = new int[pq.size()];
        int index = 0;
        while(!pq.isEmpty()){
            ans[index++] = pq.peek().second;
            pq.poll();
        }
        int l = 0;
        int r = ans.length-1;
        while(l<r){
            int temp = ans[l];
            ans[l] = ans[r];
            ans[r] = temp;
            l++;
            r--;
        }
        return ans;
    }
}