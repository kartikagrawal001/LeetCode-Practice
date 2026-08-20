class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] v : reservedSeats) {
            map.putIfAbsent(v[0], new int[10]);
            map.get(v[0])[v[1] - 1] = 1;
        }
        int count = 2 * (n - map.size());
        for (int rowNum : map.keySet()) {
            int[] row = map.get(rowNum);
            if (validblock(1, 4, row)) {
                count++;
                if (validblock(5, 8, row))
                    count++;
            }
            else if (validblock(3, 6, row)) {
                count++;
            }
            else if (validblock(5, 8, row)) {
                count++;
            }
        }
        return count;
    }
    public boolean validblock(int start, int end, int[] row) {
        for (int i = start; i <= end; i++) {
            if (row[i] != 0)
                return false;
        }
        return true;
    }
}