class Solution {
    public boolean prod(int n,int t){
        int prod = 1;
        while(n>0){
            prod*=(n%10);
            n/=10;
        }
        return prod % t == 0;
    }
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=100;i++){
            if(prod(i,t))return i;
        }
        return -1;
    }
}