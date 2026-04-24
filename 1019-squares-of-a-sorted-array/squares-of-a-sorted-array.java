class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num >= 0) pos.add(num);
            else neg.add(num);
        }
        for (int i = 0; i < pos.size(); i++) {
            pos.set(i, pos.get(i) * pos.get(i));
        }
        for (int i = 0; i < neg.size(); i++) {
            neg.set(i, neg.get(i) * neg.get(i));
        }
        int l = 0, r = neg.size() - 1;
        while (l < r) {
            int temp = neg.get(l);
            neg.set(l, neg.get(r));
            neg.set(r, temp);
            l++;
            r--;
        }
        int i = 0, j = 0, k = 0;
        int[] ans = new int[pos.size() + neg.size()];

        while (i < pos.size() && j < neg.size()) {
            if (pos.get(i) <= neg.get(j)) {
                ans[k++] = pos.get(i++);
            } else {
                ans[k++] = neg.get(j++);
            }
        }

        while (i < pos.size()) ans[k++] = pos.get(i++);
        while (j < neg.size()) ans[k++] = neg.get(j++);

        return ans;
    }
}