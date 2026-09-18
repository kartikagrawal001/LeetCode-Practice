class Solution {
    public int maxProduct(int[] nums) {
        int minbest = nums[0];
        int maxbest = nums[0];
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            int v1 = minbest * nums[i];
            int v2 = maxbest * nums[i];
            int v3 = nums[i];
            maxbest = Math.max(v1,Math.max(v2,v3));
            minbest =  Math.min(v1,Math.min(v2,v3));
            ans = Math.max(ans,Math.max(maxbest,minbest));
        }
        return ans;
    }
}