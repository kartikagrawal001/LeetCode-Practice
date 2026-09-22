class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []prepro = new int[nums.length];
        prepro[0]=1;
        for(int i=1;i<nums.length;i++){
            prepro[i] = prepro[i-1]*nums[i-1];
        }
        int []suffpro = new int[nums.length];
        suffpro[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--){
            suffpro[i] = suffpro[i+1]*nums[i+1];
        }
        int[]ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i] = prepro[i]*suffpro[i];
        }
        return ans;
    }
}