class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int arr[] = new int[n+1];
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=gain[i];
            arr[i+1] = sum;
        }
        Arrays.sort(arr);
        return arr[n];
    }
}