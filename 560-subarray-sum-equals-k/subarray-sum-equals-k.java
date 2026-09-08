class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int ans = 0;
        for(int v:nums){
            sum+=v;
            int need = sum-k;
            if(map.containsKey(need))ans+=map.get(need);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}