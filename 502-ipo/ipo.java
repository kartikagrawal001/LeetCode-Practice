class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital){
        int n = profits.length;
        int[][]arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        while(k>0){
            while(idx<n){
                if(arr[idx][0]>w)break;
                else{
                    pq.offer(arr[idx][1]);
                    idx++;
                }
            }
            if(pq.isEmpty())return w;
            w+=pq.poll();
            k--;
        }
        return w;
    }
}