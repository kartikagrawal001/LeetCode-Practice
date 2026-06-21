class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        for (int c:costs) {
            if (coins<c) break;
            coins-=c;
            ans++;
        }
        return ans;
    }
}