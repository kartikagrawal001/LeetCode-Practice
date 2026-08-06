class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)q.offer(new int[]{i,j});
                else if(grid[i][j]==1)fresh++;
            }
        }
        int[]x = {-1,1,0,0};
        int[]y = {0,0,-1,1};
        while(!q.isEmpty() && fresh>0){
            time++;
            int s = q.size();
            while(s>0){
                int[]curr = q.poll();
                int i = curr[0];
                int j = curr[1];
                for(int k=0;k<4;k++){
                    int r = i + x[k];
                    int c = j + y[k];
                    if(r>=m||c>=n||r<0||c<0||grid[r][c]!=1)continue;
                    q.offer(new int[]{r,c});
                    grid[r][c] = -2;
                    fresh--;
                }
                s--;
            }
        }
        if(fresh>0)return -1;
        return time;
    }
}