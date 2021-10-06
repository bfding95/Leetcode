/**
 * date 2021/10/5
 * problem：https://leetcode.com/problems/container-with-most-water/
 */

/*
    Solution:
    Two pointers:  mathematics :)
 */
public class containerWIthMostWater_11 {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {

            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
