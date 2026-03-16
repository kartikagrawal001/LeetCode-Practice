import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                set.add(grid[i][j]);

                int maxSize = Math.min(Math.min(i, m - 1 - i), Math.min(j, n - 1 - j));

                for (int k = 1; k <= maxSize; k++) {
                    int sum = 0;

                    int r = i - k, c = j;

                    for (int d = 0; d < k; d++)
                        sum += grid[r + d][c + d];

                    for (int d = 0; d < k; d++)
                        sum += grid[i + d][j + k - d];

                    for (int d = 0; d < k; d++)
                        sum += grid[i + k - d][j - d];

                    for (int d = 0; d < k; d++)
                        sum += grid[i - d][j - k + d];

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] ans = new int[size];

        int idx = 0;
        for (int val : set) {
            if (idx == 3) break;
            ans[idx++] = val;
        }

        return ans;
    }
}