class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> st = new Stack<>(); 
        for(String s:arr){
            if(s.equals("")||s.equals("."))continue;
            else if(s.equals("..")){
                if(!st.isEmpty())st.pop();
            }
            else st.push(s);
        }
        if(st.size()==0)return "/";
        StringBuilder sb = new StringBuilder();
        for(String s:st){
            sb.append("/").append(s);
        }
        return sb.toString();
    }
}