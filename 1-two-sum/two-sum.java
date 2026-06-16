class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int need=target-nums[i];
            if(hm.containsKey(need)) return new int[]{i,hm.get(need)};
            hm.put(nums[i],hm.getOrDefault(nums[i],i));
        } 
        return new int[]{};
    }
}