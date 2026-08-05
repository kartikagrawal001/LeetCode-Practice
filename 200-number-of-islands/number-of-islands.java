class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][]vis = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                    dfs(i,j,m,n,grid,vis);
                    count++;
                }
            }
        }
        return count;
    }
    int[]x = {-1,1,0,0};
    int[]y = {0,0,-1,1};
    public void dfs(int i,int j,int m,int n,char[][]grid,boolean[][]vis){
        vis[i][j]= true;
        for(int k=0;k<4;k++){
            int row = i + x[k];
            int col = j + y[k];
            if(row<0||col<0||row>=m||col>=n||grid[row][col]=='0'||vis[row][col]==true)continue;
            dfs(row,col,m,n,grid,vis);
        }
    }
}