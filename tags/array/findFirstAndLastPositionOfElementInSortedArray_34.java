/**
 * date 2021/10/6
 * problem：https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

/*
    Solution:
        1. binary search find first index
            a.condition: nums[i] == target and nums[i - 1] < nums[target]
            b.edge case: nums[i] == target and i == 0
        2. binary search find last index
 */

public class findFirstAndLastPositionOfElementInSortedArray_34 {

    public int[] searchRange(int[] nums, int target) {

        int len = nums.length;
        int[] res = new int[] {-1, -1};
        if (len == 1) {
            return nums[0] == target ? new int[] {0, 0} : res;
        }

        res[0] = findFirstIndex(nums, target);
        res[1] = findLastIndex(nums, target);

        return res;
    }

    private int findFirstIndex(int[] nums, int target) {
        //condition: nums[i] == target and nums[i - 1] < nums[target]
        //edge case: nums[i] == target and i == 0

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if ((mid == 0 || nums[mid - 1] < nums[mid])) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    private int findLastIndex(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if ((mid == nums.length - 1 || nums[mid + 1] > nums[mid])) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
