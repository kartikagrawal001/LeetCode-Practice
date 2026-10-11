class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int arr[] = new int[n*n];
        int i = 0;
        for(int[]a:matrix){
            for(int v:a){
                arr[i++] = v;
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }
}