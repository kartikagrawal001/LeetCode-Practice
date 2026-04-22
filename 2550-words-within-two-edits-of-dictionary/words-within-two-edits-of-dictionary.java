class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();
        for(String s2:queries){
            for(String s1:dictionary){
                int count = 0;
                for(int i=0;i<s1.length();i++){
                    if(s1.charAt(i)!=s2.charAt(i))count++;
                    if(count>2)break;
                }
                if(count<=2){
                    list.add(s2);
                    break;
                }
            }
        }
        return list;
    }
}