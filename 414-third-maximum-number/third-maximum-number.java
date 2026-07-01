class Solution {
    public int thirdMax(int[] arr) {
        int n=arr.length;
        long first=Long.MIN_VALUE;
        long sec=Long.MIN_VALUE;
        long thrd=Long.MIN_VALUE;
        for(int el:arr){
            long v=(long)el;
            if(v>first){
                thrd=sec;
                sec=first;
                first=v;
            }else if(v>sec && v!=first){
                thrd=sec;
                sec=v;
            }else if(v>thrd && v!=first && v!=sec){
                thrd=v;
            }
        }
        if(thrd==Long.MIN_VALUE)return (int)first;
        return (int)thrd;
    }
}