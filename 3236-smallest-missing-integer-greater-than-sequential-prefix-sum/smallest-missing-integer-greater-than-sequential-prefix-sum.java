class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-1!=nums[i-1])break;
            sum+=nums[i];
        }
        Set<Integer> set = new HashSet<>();
        for(int v:nums)set.add(v);
        while(set.contains(sum)){
            sum++;
        }
        return sum;
    }
}