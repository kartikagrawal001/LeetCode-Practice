class Solution {
    public int lengthOfLIS(int[] nums) {
        int res[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]) res[i] = Math.max(res[i],res[j]+1);
            }
        }
        int ans = 1;
        for(int v:res)ans = Math.max(ans,v);
        return ans;
    }
}