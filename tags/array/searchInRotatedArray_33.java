/**
 * date 2021/10/6
 * problem：https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

/*
    Solution:
        1. find the index i of the smallest element in rotated array -> binary search
        2. compare target with nums[0]
        3. binary search on left/right side, pivot: i (smallest element)

        tips: consider the edge case:
            1. not rotated array
            2. target == smallest element -> might lead search problem between step 2 to 3.

 */
public class searchInRotatedArray_33 {

    public int search(int[] nums, int target) {

        int len = nums.length;

        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int pivot = findRotateIndex(nums);
        System.out.println(pivot);

        if (nums[pivot] == target) {
            return pivot;
        }

        if (pivot == 0) {
            return searchTarget(nums, target, 0, len - 1);
        }

        if (target >= nums[0]) {
            return searchTarget(nums, target, 0, pivot);
        } else {
            return searchTarget(nums, target, pivot, len - 1);
        }
    }

    private int searchTarget(int nums[], int target, int left, int right) {

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    private int findRotateIndex(int nums[]) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] < nums[right]) {
            return 0;
        }

        // find the pivot -> find the smallest element.
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else {
                if (nums[mid] < nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return 0;
    }
}
