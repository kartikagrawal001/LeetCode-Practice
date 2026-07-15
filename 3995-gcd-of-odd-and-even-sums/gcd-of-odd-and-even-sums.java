class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddsum = 0;
        int evensum = 0;
        for(int i=1;i<=n*2;i++){
            if(i%2==0)evensum+=i;
            else oddsum+=i;
        }
        while(evensum!=0){
            int temp = evensum;
            evensum = oddsum%evensum;
            oddsum = temp;
        }
        return oddsum;
    }
}