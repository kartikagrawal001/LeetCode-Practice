class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []suffpro = new int[nums.length];
        suffpro[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--){
            suffpro[i] = suffpro[i+1]*nums[i+1];
        }
        int prepro = 1;
        int[]ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i] = prepro*suffpro[i];
            prepro*=nums[i];
        }
        return ans;
    }
}