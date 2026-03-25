class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long sum1 = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                sum1+=grid[i][j];
            }
        }
        long sum2 = sum1;
        long presum  = 0;
        for(int i=0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                presum+=grid[i][j];
                sum1-=grid[i][j];
            }
            if(sum1==presum)return true;
        }
        presum = 0;
        for(int i=0;i<grid[0].length;i++){
            for(int j = 0;j<grid.length;j++){
                presum+=grid[j][i];
                sum2-=grid[j][i];
            }
            if(sum2==presum)return true;
        }
        return false;
    }
}