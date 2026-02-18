class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int currgcd = nums[i];
            if(currgcd==k)count++;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<k)break;
                currgcd = gcd(nums[j],currgcd);
                if(currgcd==k)count++;
            }
        }
        return count;
    }
    private int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
}