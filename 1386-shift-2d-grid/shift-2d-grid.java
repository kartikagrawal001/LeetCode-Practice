class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k = k%(m*n);
        while(k>0){
            int prev = grid[m-1][n-1];
            for(int i=0;i<m;i++){
                for(int j = 0;j<n;j++){
                    int temp = grid[i][j];
                    grid[i][j] = prev;
                    prev = temp;
                }
            }
            k--;
        }
        return (List)Arrays.asList(grid);
    }
}