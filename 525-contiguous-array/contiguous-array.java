class Solution {
    public int findMaxLength(int[] nums) {
        int ans = 0;
        int zero = 0;
        int one = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i= 0;i<nums.length;i++){
            if(nums[i]==0)zero++;
            else one++;
            int diff = zero-one;
            if(diff==0){
                ans = Math.max(ans,i+1);
                continue;
            }
            if(!map.containsKey(diff))map.put(diff,map.getOrDefault(diff,i));
            else ans = Math.max(ans,i-map.get(diff));
            
        }
        return ans;
    }
}