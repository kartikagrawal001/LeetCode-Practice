class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int mod = 12345;
        int n = grid.length, m = grid[0].length;
        int[][] ans = new int[n][m];

        long pre = 1;
        for (int i = 0; i < n * m; i++) {
            int r = i / m, c = i % m;
            ans[r][c] = (int) pre;
            pre = (pre * grid[r][c]) % mod;
        }

        long suf = 1;
        for (int i = n * m - 1; i >= 0; i--) {
            int r = i / m, c = i % m;
            ans[r][c] = (int) ((ans[r][c] * suf) % mod);
            suf = (suf * grid[r][c]) % mod;
        }

        return ans;
    }
}