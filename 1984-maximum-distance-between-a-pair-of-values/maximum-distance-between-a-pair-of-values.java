class Solution {
    int len2;

    public int maxDistance(int[] arr1, int[] arr2) {
        len2 = arr2.length;
        int len1 = arr1.length;
        int maxDist = 0;

        for (int i = 0; i < len1; i++) {
            maxDist = Math.max(maxDist, findFarthestIndex(arr1[i], i, arr2));
        }
        return maxDist;
    }

    public int findFarthestIndex(int value, int startIdx, int[] arr2) {
        int left = startIdx;
        int right = len2 - 1;
        int bestIdx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr2[mid] >= value) {
                bestIdx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (bestIdx == -1) ? 0 : bestIdx - startIdx;
    }
}