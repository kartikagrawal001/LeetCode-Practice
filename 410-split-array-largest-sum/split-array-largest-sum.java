class Solution {
    public boolean possible(int guess,int[]nums,int k){
        int c = 1;
        int sum = 0;
        for(int v:nums){
            if(sum+v<=guess)sum+=v;
            else{
                c++;
                sum = v;
            }
        }
        if(c<=k)return true;
        else return false;
    }
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int v:nums){
            low = Math.max(v,low);
            high += v;
        }
        while(low<=high){
            int guess = low + (high-low)/2;
            if(possible(guess,nums,k)){
                high = guess-1;
            }
            else{
                low = guess + 1;
            }
        }
        return low;
    }
}