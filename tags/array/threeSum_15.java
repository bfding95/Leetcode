import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * date 2021/10/5
 * problem：https://leetcode.com/problems/3sum/
 */

/*
    Solution: sort -> two sum -> O(n^2)

    tips: how to remove duplicates: while loop
 */
public class threeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            // remove duplicates
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums, i, res);
            }
        }

        return res;
    }


    private void twoSum(int[] nums, int index, List<List<Integer>> res) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int target = -nums[index];

        for (int i = index + 1; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {

                List<Integer> list = new ArrayList<>();
                list.add(nums[index]);
                list.add(nums[map.get(nums[i])]);
                list.add(nums[i]);
                res.add(list);
                // remove duplicates
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            map.put(target - nums[i], i);
        }
    }
}
