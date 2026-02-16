class Solution {
    public int reverseBits(int n) {
        int r = Integer.reverse(n);
        String bin = Integer.toBinaryString(r);
        return Integer.parseInt(bin,2);
    }
}