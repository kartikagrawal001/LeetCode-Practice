class Solution {
    public int minOperations(String s) {
        int count1 = 0;
        for(int i=0;i<s.length();i++){
            if(i%2==0 && s.charAt(i)=='0')continue;
            else if(i%2==1 && s.charAt(i)=='1')continue;
            count1++;
        }
        int count2 = 0;
        for(int i=0;i<s.length();i++){
            if(i%2==0 && s.charAt(i)=='1')continue;
            else if(i%2==1 && s.charAt(i)=='0')continue;
            count2++;
        }
        if(count1<=count2)return count1;
        return count2;
    }
}