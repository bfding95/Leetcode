/**
 * date 2021/10/6
 * problem：https://leetcode.com/problems/remove-element/
 */

/*
    Solution: in-place remove -> we need to record the match element index and current index

    use a pointer to record new array index:

    [1, 2, 1, 2, 3], 2
    new array -> [1] -> [1, 2] -> [1, 1] -> [1,1,2] -> [1,1,3]

 */
public class removeElement_27 {

    public int removeElement(int[] nums, int val) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[index] = nums[i];
            if (nums[i] != val) {
                index++;
            }
        }
        return index;
    }
}
