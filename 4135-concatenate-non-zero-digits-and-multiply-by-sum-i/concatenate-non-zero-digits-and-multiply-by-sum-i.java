class Solution {
    public long sumAndMultiply(int n) {
        long rev = 0;
        while(n!=0){
            long r = n%10;
            if(r!=0)rev= rev*10+r;
            n/=10;
        }
        long ans= 0;
        long sum = 0;
        while(rev!=0){
            long r  = rev%10;
            ans = ans*10+r;
            rev/=10;
            sum+=r;
        }
        return ans*sum;
    }
}