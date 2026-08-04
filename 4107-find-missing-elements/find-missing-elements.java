class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int first = nums[0];
        int last = nums[nums.length-1];
        Set<Integer> set = new HashSet<>();
        for(int v:nums)set.add(v);
        List<Integer> list = new ArrayList<>();
        for(int i=first+1;i<last;i++){
            if(!set.contains(i))list.add(i);
        }
        return list;
    }
}