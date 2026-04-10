class Solution {
    public int minimumDistance(int[] nums) {
        int min = Integer.MAX_VALUE;
        boolean f = false;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i] == nums[j] && nums[j] == nums[k]){
                        int distance=Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i);
                        min = Math.min(min,distance);
                        f = true;
                    }
                }
            }
        }
        if(f)return min;
        return -1;
    }
}