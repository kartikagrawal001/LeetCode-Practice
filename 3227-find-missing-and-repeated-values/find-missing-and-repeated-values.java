class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int sum=0;
        int rep=0;
        Set<Integer> st=new HashSet<>();
        for(int[] row:grid){
            for(int c:row){
                sum+=c;
                if(st.contains(c) )rep=c;
                st.add(c);
            }
        }
        int n=grid.length;
        n=n*n;
        int stdsum=((n*(n+1))/2);
        return new int[] {rep,(stdsum-sum)+rep};

    }
}