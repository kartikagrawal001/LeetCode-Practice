class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int currmax = 0;
        int maxLen = 0;
        int low = 0;
        for(int high=0;high<nums.length;high++){
            int no = nums[high];
            map.put(no,map.getOrDefault(no,0)+1);
            currmax = Math.max(currmax,map.get(no));
            if(currmax>k){
                int want = no;
                while(nums[low]!=want){
                    int no2 = nums[low];
                    map.put(no2,map.getOrDefault(no2,0)-1);
                    low++;
                }
                map.put(want,map.getOrDefault(want,0)-1);
                low++;
                currmax--;
            }
            maxLen = Math.max(maxLen,high-low+1);
        }
        return maxLen;
    }
}