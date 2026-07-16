class Solution {
    public long gcdSum(int[] nums) {
        int[] arr=new int[nums.length];
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            int a=max;
            int b=nums[i];
            while(b!=0){
                int temp=b;
                b=a%b;
                a=temp;
            }
            arr[i]=a;
        }
        Arrays.sort(arr);
        int i=0;
        int j=nums.length-1;
        long sum=0;
        while(i<j){
            int a=arr[i];
            int b=arr[j];
            while(b!=0){
                int temp=b;
                b=a%b;
                a=temp;
            }
            sum+=a;
            i++;
            j--;
        }
        return sum;
    }
}