class Solution {
    public boolean valid(int[]arr1,int arr2[]){
        for(int i=0;i<128;i++){
            if(arr2[i]<arr1[i])return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int[]arr1 = new int[128];
        int[]arr2 = new int[128];
        for(char c:t.toCharArray()){
            arr1[c]++;
        }
        int low = 0;
        int min = Integer.MAX_VALUE;
        String ans = "";
        for(int high = 0;high<s.length();high++){
            char c = s.charAt(high);
            arr2[c]++;
            while(valid(arr1,arr2)){
                if(high-low+1<min){
                    ans = s.substring(low,high+1);
                    min = high-low+1;
                }
                char c2 = s.charAt(low);
                arr2[c2]--;
                low++;
            }
        }
        return ans;
    }
}