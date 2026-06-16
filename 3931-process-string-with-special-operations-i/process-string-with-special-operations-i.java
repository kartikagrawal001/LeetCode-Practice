class Solution {
    public String processStr(String s) {
        StringBuilder st = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='*'){
                if(st.length()>0)st.delete(st.length()-1,st.length());
            }
            else if(ch=='#'){
                st.append(st);
            }
            else if(ch=='%')st.reverse();

            else st.append(ch);
        }
        return st.toString();
    }
}