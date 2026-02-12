class Solution {
    public int longestBalanced(String s) {
        int max = 0;
        for(int i=0;i<s.length();i++){
            int arr[] = new int[26];
            for(int j=i;j<s.length();j++){
                arr[s.charAt(j)-'a']++;
                if(isbalanced(arr)){
                    max = Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
    public boolean isbalanced(int[]arr){
        int a = 0;
        for(int v:arr){
            if(a==0)a=v;
            if(v==0)continue;
            else if(v!=a)return false;
        }
        return true;
    }
}