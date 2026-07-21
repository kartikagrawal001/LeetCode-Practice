class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int count1 = 0;
        for(char c:s.toCharArray())if(c=='1')count1++;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(i<s.length()){
            if(s.charAt(i)=='0'){
                int st = i;
                while(i<s.length() && s.charAt(i)=='0')i++;
                list.add(i-st);
            }
            else i++;
        }
        int max = 0;
        for(int j=1;j<list.size();j++){
            max = Math.max(max,list.get(j)+list.get(j-1));
        }
        return max + count1;
    }
}