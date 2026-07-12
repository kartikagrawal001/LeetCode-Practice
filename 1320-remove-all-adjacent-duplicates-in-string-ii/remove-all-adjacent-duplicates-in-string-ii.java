class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st = new Stack<>();
        for(char ch:s.toCharArray()){
            if(st.isEmpty() || (char)st.peek()[0]!=ch){
                st.push(new int[]{ch,1});
            }
            else if(st.peek()[1]<k){
                st.peek()[1]++;
            }
            if(st.peek()[1]==k)st.pop();
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            char ch = (char)st.peek()[0];
            int times = st.peek()[1];
            st.pop();
            while(times>0){
                ans.append(ch);
                times--;
            }
        }
        return ans.reverse().toString();
    }
}