class Solution {
    public int minimumPushes(String word) {
        int arr[]= new int[26];
        for(char ch:word.toCharArray()){
            arr[ch-'a']++;
        }
        Arrays.sort(arr);
        int count  = 0;
        int sum = 0;
        for(int i=arr.length-1;i>=0;i--){
            count++;
            if(count<=8)sum+=arr[i];
            else if(count>8 && count<=16)sum+=arr[i]*2;
            else if(count>16 && count<=24)sum+=arr[i]*3;
            else sum+=arr[i]*4;
        }
        return sum;
    }
}