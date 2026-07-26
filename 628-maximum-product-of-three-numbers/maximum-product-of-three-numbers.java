class Solution {
    public int maximumProduct(int[] nums) {
        int first  = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int v:nums){
            if(v>first){
                third = second;
                second = first;
                first = v;
            }
            else if(v>second){
                third = second;
                second = v;
            }
            else if(v>third)third = v;
            if(v<min1){
                min2 = min1;
                min1 = v;
            }
            else if(v<min2){
                min2 = v;
            }
        }
        return Math.max(first*second*third,first*min1*min2);
    }
}