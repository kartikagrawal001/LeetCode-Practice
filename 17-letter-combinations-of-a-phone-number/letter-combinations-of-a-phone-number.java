class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(0,digits,sb,ans,map);
        return ans;
    }
    public void helper(int idx,String digits,StringBuilder temp,List<String> ans, Map<Character,String> map){
        if(idx==digits.length()){
            ans.add(temp.toString());
            return;
        }
        char c = digits.charAt(idx);
        String alpha = map.get(c);
        for(char ch:alpha.toCharArray()){
            temp.append(ch);
            helper(idx+1,digits,temp,ans,map);
            temp.deleteCharAt(temp.length()-1);
        }
        return;
    }
}