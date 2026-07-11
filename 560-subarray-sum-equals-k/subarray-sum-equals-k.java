class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,map.getOrDefault(0,0)+1);
        int presum = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            presum+=nums[i];
            int need = presum-k;
            if(map.containsKey(need))count+=map.get(need);
            map.put(presum,map.getOrDefault(presum,0)+1);
        }
        return count;
    }
}