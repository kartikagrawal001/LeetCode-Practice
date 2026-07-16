class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch:s.toCharArray()){
            if(st.isEmpty())st.push(ch);
            else if(st.peek()==ch)st.pop();
            else st.push(ch);
        }
        String str = "";
        for(char ch :st){
            str+=ch;
        }
        return str;
    }
}