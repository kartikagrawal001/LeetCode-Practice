class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int presum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,map.getOrDefault(0,0)+1);
        for(int i = 0;i<nums.length;i++){
            presum+=nums[i];
            int r = presum % k;
            if(r<0)r = r + k;
            if(map.containsKey(r))count+=map.get(r);
            map.put(r,map.getOrDefault(r,0)+1);
        }
        return count;
    }
}