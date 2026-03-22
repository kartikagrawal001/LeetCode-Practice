class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int r = 0; r < 4; r++) {
            if (same(mat, target)) return true;
            mat = rotate(mat);
        }
        return false;
    }

    private boolean same(int[][] a, int[][] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }

    private int[][] rotate(int[][] a) {
        int n = a.length;
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - 1 - i] = a[i][j];
            }
        }
        return res;
    }
}