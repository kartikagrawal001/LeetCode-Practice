class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i=left;i<=right;i++){
            if(isprime(i))count++;
        }
        return count;
    }
    public boolean isprime(int n){
        String b = Integer.toBinaryString(n);
        int c = 0;
        for(char ch:b.toCharArray()){
            if(ch=='1')c++;
        }
        if(c<2)return false;
        for(int i=2;i<c;i++){
            if(c%i==0)return false;
        }
        return true;
    }
}