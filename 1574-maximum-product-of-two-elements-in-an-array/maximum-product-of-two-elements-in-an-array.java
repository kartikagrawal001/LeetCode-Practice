class Solution {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int v:nums){
            if(v>max1){
                max2 = max1;
                max1 = v;
            }
            else if(v>max2)max2 = v;
        }
        return (max1-1)*(max2-1);
    }
}