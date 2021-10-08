/**
 * date 2021/10/7
 * problem：https://leetcode.com/problems/search-insert-position/
 */

/*
    Solution:
        1. binary search
        2. record the mid value and this value will be the last element near to target if the target not found in search
        3. return nums[mid] > target ? mid : mid + 1;
 */


public class searchInsertPosition_35 {

    public int searchInsert(int[] nums, int target) {

        int len = nums.length;

        if (len == 1) {
            return nums[0] == target ? 0 : nums[0] > target ? 0 : 1;
        }

        int left = 0;
        int right = len - 1;
        int mid = 0;

        while (left <= right) {

            mid = (left + right) / 2;
            System.out.println(mid);

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return nums[mid] > target ? mid : mid + 1;
    }
}
