class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->Integer.compare(a[1],b[1]));
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int totaltime = 0;
        for(int[]arr:courses){
            totaltime+=arr[0];
            pq.offer(arr[0]);
            if(totaltime>arr[1])totaltime-=pq.poll();
        }
        return pq.size();
    }
}