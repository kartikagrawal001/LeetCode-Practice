class Solution {
    public int maximumLengthSubstring(String s) {
        int arr[] = new int[256];
        int low = 0;
        int ans = 0;
        for(int high = 0;high<s.length();high++){
            char ch = s.charAt(high);
            arr[ch]++;
            if(arr[ch]>2){
                while(arr[ch]>2){
                    char ch2 = s.charAt(low);
                    low++;
                    arr[ch2]--;
                }
            }
            ans = Math.max(ans,high-low+1);
        }
        return ans;
    }
}