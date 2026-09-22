class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[] = new int[nums1.length+nums2.length];
        for(int i=0;i<nums1.length;i++)arr[i] = nums1[i];
        for(int i=0;i<nums2.length;i++)arr[i+nums1.length] = nums2[i];
        Arrays.sort(arr);
        double ans = 0;
        if(arr.length%2!=0)ans = (double)arr[arr.length/2];
        else{
            double mid = (double)(arr[arr.length/2-1]+arr[arr.length/2])/2;
            ans = mid;
        }
        return ans;
    }
}