class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if(st.isEmpty())pse[i]=-1;
            else pse[i]= st.peek();
            st.push(i);
        }
        st.clear();
        int[] nse = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if(st.isEmpty())nse[i]=n;
            else nse[i]= st.peek();
            st.push(i);
        }
        int maxarea = 0;
        for(int i=0;i<n;i++){
            int width = nse[i]-pse[i]-1;
            maxarea = Math.max(maxarea,width*arr[i]);
        }
        return maxarea;
    }
}