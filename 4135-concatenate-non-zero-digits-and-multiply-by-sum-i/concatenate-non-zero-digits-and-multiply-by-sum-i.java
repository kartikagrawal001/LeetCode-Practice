class Solution {
    public long sumAndMultiply(int n) {
        int x= 0;
        int sum = 0;
        int i = 1;
        while(n!=0){
            int r = n%10;
            n/=10;
            if(r==0)continue;
            x+=(r*i);
            i*=10;
            sum+=r;
        }
        return (long) x * sum;
    }
}