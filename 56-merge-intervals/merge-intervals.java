class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int n = intervals.length;
        int p1 = intervals[0][0];
        int p2 = intervals[0][1];
        List<int []> list = new ArrayList<>();
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=p2){
                p2 = Math.max(p2,intervals[i][1]);
            }
            else{
                list.add(new int[]{p1,p2});
                p1 = intervals[i][0];
                p2 = intervals[i][1];
            }
        }
        list.add(new int[]{p1,p2});
        int [][] arr = new int[list.size()][2];
        int idx = 0;
        for(int[]v:list){
            arr[idx][0] = v[0];
            arr[idx][1] = v[1];
            idx++;
        }
        return arr;
    }
}