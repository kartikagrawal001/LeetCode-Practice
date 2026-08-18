class Solution {
    public int largestInteger(int[] nums, int k) {
        int arr[] = new int[51];
        for(int i=0;i<=nums.length-k;i++){
            Set<Integer> set = new HashSet<>();
            for(int j = i;j<i+k;j++){
                if(!set.contains(nums[j]))set.add(nums[j]);
            }
            for(int v:set)arr[v]++;
        }
        int found = -1;
        for(int i=0;i<=50;i++){
            if(arr[i]==1){
                found = i;
            }
        }
        return found;
    }
}