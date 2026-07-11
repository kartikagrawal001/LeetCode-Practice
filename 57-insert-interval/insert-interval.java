class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length+1;
        int newarr[][] = new int[n][2];
        int idx = 0;
        for(int[]arr:intervals){
            newarr[idx][0] = arr[0];
            newarr[idx][1] = arr[1];
            idx++;
        }
        newarr[idx][0] = newInterval[0];
        newarr[idx][1] = newInterval[1];
        Arrays.sort(newarr,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> list = new ArrayList<>();
        int p1 = newarr[0][0];
        int p2 = newarr[0][1];
        for(int i=1;i<newarr.length;i++){
            if(newarr[i][0]<=p2)p2 = Math.max(p2,newarr[i][1]);
            else{
                list.add(new int[]{p1,p2});
                p1 = newarr[i][0];
                p2 = newarr[i][1];
            }
        }
        list.add(new int[]{p1,p2});
        int ans[][] = new int[list.size()][2];
        idx = 0;
        for(int[]v:list){
            ans[idx][0] = v[0];
            ans[idx][1] = v[1];
            idx++; 
        }
        return ans;
    }
}