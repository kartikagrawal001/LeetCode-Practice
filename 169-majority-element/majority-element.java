class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int prev = 0;
        for(int v:nums){
            if(count==0)prev = v;
            if(v==prev)count++;
            else count--;
        }
        return prev;
    }
}