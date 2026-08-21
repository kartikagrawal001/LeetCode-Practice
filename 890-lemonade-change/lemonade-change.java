class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int v:bills){
            if(v==5)five++;
            else if(v==10){
                if(five==0)return false;
                five--;
                ten++;
            }
            else{
                if(ten>=1){
                    ten--;
                    if(five==0)return false;
                    five--;
                }
                else{
                    if(five<3)return false;
                    five-=3;
                }
            }
        }
        return true;
    }
}