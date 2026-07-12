class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length;
        int m = secondList.length;
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i< n && j< m){
            int s1 = firstList[i][0];
            int e1 = firstList[i][1];
            int s2 = secondList[j][0];
            int e2 = secondList[j][1];
            if(s1<=s2 && s2<=e1 ){
                int a = Math.max(s1,s2);
                int b = Math.min(e1,e2);
                list.add(new int[]{a,b});
            }
            else if(s2<=s1 && e2>=s1){
                int a = Math.max(s1,s2);
                int b = Math.min(e1,e2);
                list.add(new int[]{a,b});
            }
            if(e1>=e2 && e2<=e1)j++;
            else i++;
        }
        int[][] ans = new int[list.size()][2];
        int idx = 0;
        for(int []v:list){
            ans[idx][0] = v[0];
            ans[idx++][1] = v[1];
        }
        return ans;
    }
}