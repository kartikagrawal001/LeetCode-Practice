class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(char c:s.toCharArray()){
            if(c=='b')st.push(c);
            else{
                if(!st.isEmpty()){
                    count++;
                    st.pop();
                }
            }
        }
        return count;
    }
}