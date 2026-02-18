class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0];
        int b = nums[nums.length-1];
        int div = b;
        for(int i=div;i>=1;i--){
            if(a%i==0 && b%i==0)return i;
        }
        return 1;
    }
}