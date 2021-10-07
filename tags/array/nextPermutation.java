/**
 * date 2021/10/6
 * problem：https://leetcode.com/problems/next-permutation/
 */

/*
    Solution: 1 - 2 - 5 - 6 - 4 - 3

    steps: 1. go through the array from end to start. -> if the elements is ascending, is the largest Permutation
    2. if not, find the first not ascending element -> 5
    3. find the element which is larger than 5 and it's closest to 5. -> 6
    4. swap 5,6
    5. reverse 5-4-3 -> to smallest permutation.

 */
public class nextPermutation {

    public void nextPermutation(int[] nums) {

        if (nums.length <= 1) {
            return;
        }

        int index = nums.length - 2;

        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }

        if (index >= 0) {
            int swapIndex = nums.length - 1;
            while (swapIndex >= index && nums[index] >= nums[swapIndex]) {
                swapIndex--;
            }
            swap(nums, index, swapIndex);
        }
        reverse(nums, index + 1, nums.length - 1);
    }


    private void swap(int[] nums, int i, int j) {

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int startIndex, int endIndex) {

        while (startIndex < endIndex) {
            swap(nums, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }

}
