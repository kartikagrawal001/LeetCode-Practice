class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        for(char ch:num.toCharArray()){
            if(st.isEmpty())st.push(ch-'0');
            else{
                while(!st.isEmpty() && k>0 && st.peek()>(ch-'0')){
                    st.pop();
                    k--;
                }
                st.push(ch-'0');
            }
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append((char)(st.peek()+'0'));
            st.pop();
        }
        sb.reverse();
        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(sb.length()==0)return "0";
        return sb.toString();
    }
}