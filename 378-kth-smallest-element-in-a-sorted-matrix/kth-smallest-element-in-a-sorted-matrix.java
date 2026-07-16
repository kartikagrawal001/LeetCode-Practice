class Solution {
    public boolean ispossible(int[][]matrix,int k,int guess){
        int sum = 0;
        int r = matrix.length-1;
        int c = 0;
        while(r>=0 && c<matrix[0].length){
            if(matrix[r][c]<=guess){
                sum+=(r+1);
                c++;
            }
            else{
                r--;
            }
        }
        if(sum>=k)return true;
        else return false;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix[0].length-1];
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(ispossible(matrix,k,mid)){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
}