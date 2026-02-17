class Solution {
    public int minElement(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i] = SumIt(nums[i]);
        }
        Arrays.sort(nums);
        return nums[0];
    }
    private int SumIt(int n){
        int sum = 0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}