class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while(fast!=1){
            slow = find(slow);
            fast = find(fast);
            fast = find(fast);
            if(slow==fast && slow!=1){
                return false;
            }
        }
        return true;
    }
    public int find(int n){
        int sum = 0;
        while(n!=0){
            int r = n%10;
            sum+=r*r;
            n/=10;
        }
        return sum;
    }
}