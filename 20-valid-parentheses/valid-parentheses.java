class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('||ch=='{'||ch=='[')st.push(ch);
            else if(st.isEmpty())return false;
            else{
                char last = st.pop();
                if(ch==')' && last!='(')return false;
                else if(ch=='}' && last!='{')return false;
                else if(ch==']' && last!='[')return false;
            }
        }
        return st.isEmpty();
    }
}