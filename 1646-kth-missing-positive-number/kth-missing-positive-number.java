class Solution {
    public static boolean containsValue(int[] arr, int target) {
        for (int element : arr) {
            if (element == target) {
                return true;
            }
        }
        return false;
    }
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int count=0;
        int found = -1;
        for(int i=1;i<=10000;i++){
            if(!containsValue(arr,i)){
                count++;
                if(count==k){
                    found = i;
                    break;
                }
            }
        }
        return found;
    }
}