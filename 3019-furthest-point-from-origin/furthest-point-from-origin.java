class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0;
        int r = 0;
        for(char ch : moves.toCharArray()){
            if(ch=='L')l++;
            else if(ch=='R')r++;
        }
        if(l>=r)return moves.length()-(2*r);
        else return moves.length()-(2*l);
    }
}