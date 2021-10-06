/**
 * date 2021/10/5
 * problem: https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

/*
    Solution
    log(n + m) -> log -> binary
     nums1: 1, 2, 5,| 8, 10
                  ^   ^
                  L1  R1
     nums2: 5, | 5, 7
            ^    ^
            L2   R2
    need to be satisfy below statements:

    L1 > R2  and L2 > R1 and  left length of nums1 + left length of num2 = total length / 2
    -> left length of nums2 could be determined by left length nums1
    -> so we could do binary search on nums1 until meet all conditions
 */

public class medianOfTwoSortedArray_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 == 0) {
            return len2 % 2 != 0 ? nums2[len2 / 2] : ((double) nums2[len2 / 2 - 1] + (double) nums2[len2 / 2]) / 2;
        }

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int len = len1 + len2;
        int start = 0;
        int end = len1;

        // binary search on shorter array -> O(log(min(m, n)))
        while (start <= end) {
            int mid = (start + end) / 2;
            int cutA = mid;
            int cutB = len / 2 - mid;

            int L1 = cutA == 0 ? Integer.MIN_VALUE : nums1[cutA - 1];
            int R1 = cutA == len1 ? Integer.MAX_VALUE :nums1[cutA];
            int L2 = cutB == 0 ? Integer.MIN_VALUE : nums2[cutB - 1];
            int R2 = cutB == len2 ? Integer.MAX_VALUE : nums2[cutB];

            if (L1 > R2) {
                // need to move cut to left;
                end = mid;
            } else if (L2 > R1){
                start = mid + 1;
            } else {
                return len % 2 != 0 ? Math.min(R1, R2) : ((double) Math.max(L1, L2) + (double) Math.min(R1, R2)) /2;
            }
        }

        return -1;
    }
}
