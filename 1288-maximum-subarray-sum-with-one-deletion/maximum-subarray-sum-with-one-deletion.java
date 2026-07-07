class Solution {
    public int maximumSum(int[] arr) {
        int noDel = arr[0];
        int oneDel = Integer.MIN_VALUE;
        int ans = arr[0];
        for(int i=1;i<arr.length;i++){
            int prevNoDel = noDel;
            int prevOneDel = oneDel;
            noDel = Math.max(noDel+arr[i],arr[i]);
            int v2;
            if(prevOneDel == Integer.MIN_VALUE){
                v2 = arr[i];
            }
            else v2 = prevOneDel + arr[i];
            oneDel = Math.max(v2,prevNoDel);
            ans = Math.max(ans,Math.max(oneDel,noDel));
        }
        return ans;
    }
}