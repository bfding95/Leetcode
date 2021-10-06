import java.util.Arrays;

/**
 * date 2021/10/5
 * problem：https://leetcode.com/problems/3sum-closest/
 */

/*
    Solution: closest to a target ->  two pointers -> sort -> sum > target ? right-- : left++

    Tips: how to maintain the closest sum and how to compare sum to target
    -> use another value: diff: and compare abs(diff). return target - diff as result.

 */
public class threeSumClosest_16 {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum =  nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return target - diff;
    }
}
