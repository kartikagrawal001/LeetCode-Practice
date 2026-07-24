class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0,0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    public void helper(int idx,int sum,int[]arr,int target,List<List<Integer>> ans,ArrayList<Integer> temp){
        if(idx==arr.length){
            if(sum==target)ans.add(new ArrayList<>(temp));
            return;
        }
        helper(idx+1,sum,arr,target,ans,temp);
        if(sum+arr[idx]<=target){
            sum+=arr[idx];
            temp.add(arr[idx]);
            helper(idx,sum,arr,target,ans,temp);
            sum-=arr[idx];
            temp.remove(temp.size()-1);
        }
    }
}