class Solution {

    public boolean ispossible(int m, int n, int k, int guess) {
        int sum = 0;

        for (int i = 1; i <= m; i++) {
            sum += Math.min(n, guess / i);
            if (sum >= k) return true;   // early exit
        }

        return false;
    }

    public int findKthNumber(int m, int n, int k) {

        int low = 1;
        int high = m * n;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (ispossible(m, n, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}