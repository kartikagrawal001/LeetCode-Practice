class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(typed.length()<name.length()||name.charAt(0)!=typed.charAt(0))return false;
        int i = 0;
        int j = 0;
        char prev  = 'a';
        while(i<name.length() && j<typed.length()){
            if(name.charAt(i)==typed.charAt(j)){
                prev = name.charAt(i);
                i++;
                j++;
            }
            else if(typed.charAt(j)==prev){
                j++;
            }
            else return false;

        }
        if(i!=name.length())return false;
        while (j < typed.length()) {
                if (typed.charAt(j) != prev) return false;
                j++;
            }
        return true;
    }
}