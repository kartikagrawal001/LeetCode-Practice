import java.util.*;

class SegmentTree {

    static class Node {
        int mini;
        int maxi;
        int lazy;
    }

    int n;
    Node[] seg;

    SegmentTree(int[] arr) {
        n = arr.length;
        seg = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) seg[i] = new Node();
        build(0, 0, n - 1, arr);
    }

    void apply(int node, int val) {
        seg[node].mini += val;
        seg[node].maxi += val;
        seg[node].lazy += val;
    }

    void pull(int node) {
        seg[node].mini = Math.min(seg[2 * node + 1].mini, seg[2 * node + 2].mini);
        seg[node].maxi = Math.max(seg[2 * node + 1].maxi, seg[2 * node + 2].maxi);
    }

    void push(int node) {
        if (seg[node].lazy != 0) {
            apply(2 * node + 1, seg[node].lazy);
            apply(2 * node + 2, seg[node].lazy);
            seg[node].lazy = 0;
        }
    }

    void build(int node, int l, int r, int[] arr) {
        if (l == r) {
            apply(node, arr[l]);
            return;
        }
        int mid = (l + r) / 2;
        build(2 * node + 1, l, mid, arr);
        build(2 * node + 2, mid + 1, r, arr);
        pull(node);
    }

    void update(int node, int ql, int qr, int l, int r, int val) {
        if (r < ql || l > qr) return;

        if (ql <= l && r <= qr) {
            apply(node, val);
            return;
        }
        push(node);
        int mid = (l + r) / 2;
        update(2 * node + 1, ql, qr, l, mid, val);
        update(2 * node + 2, ql, qr, mid + 1, r, val);
        pull(node);
    }

    void update(int l, int r, int val) {
        update(0, l, r, 0, n - 1, val);
    }

    int findLast(int node, int ql, int qr, int l, int r, int val) {
        if (r < ql || l > qr) return -1;
        if (seg[node].mini > val || seg[node].maxi < val) return -1;

        if (l == r) return l;
        push(node);

        int mid = (l + r) / 2;
        int res = findLast(2 * node + 2, ql, qr, mid + 1, r, val);
        if (res != -1) return res;

        return findLast(2 * node + 1, ql, qr, l, mid, val);
    }

    int findLast(int l, int r, int val) {
        return findLast(0, l, r, 0, n - 1, val);
    }
}

class Solution {
    public int longestBalanced(int[] nums) {

        int n = nums.length;
        HashMap<Integer, ArrayDeque<Integer>> map = new HashMap<>();

        int[] pre = new int[n];

        pre[0] = (nums[0] % 2 == 0) ? 1 : -1;
        map.computeIfAbsent(nums[0], k -> new ArrayDeque<>()).add(0);

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1];

            map.computeIfAbsent(nums[i], k -> new ArrayDeque<>());
            if (map.get(nums[i]).isEmpty()) {
                pre[i] += (nums[i] % 2 == 0) ? 1 : -1;
            }
            map.get(nums[i]).add(i);
        }

        SegmentTree sg = new SegmentTree(pre);

        int ans = 0;

        for (int i = 0; i < n; i++) {

            int r = sg.findLast(i + ans, n - 1, 0);
            if (r != -1) {
                ans = Math.max(ans, r - i + 1);
            }

            map.get(nums[i]).poll();
            int next = n;
            if (!map.get(nums[i]).isEmpty()) {
                next = map.get(nums[i]).peek();
            }

            sg.update(i, next - 1, (nums[i] % 2 == 0) ? -1 : 1);
        }
        return ans;
    }
}