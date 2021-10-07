import java.util.*;

/**
 * date 2021/10/6
 * problem：https://leetcode.com/problems/4sum/
 */

/*
    Solution: kSum -> k-1 Sum -> 2 Sum (two pointer or hashset)
    be careful on avoid duplicate!!!

    how to maintain the result list

    List<List<Integer>>
    res -> 2 sum -> [[5,6], [4,7]]
        -> 3 sum : for subset : res -> create a new list： add list.of(nums[i]), [[1]]
        -> use the new list last element index to find the corresponding element in 2 sum result
        -> [[1, 5, 6]] -> [[1, 5, 6], [1]] -> [[1,5,6], [1,4,7]]
 */
public class fourSum_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int index, int k) {

        List<List<Integer>> res = new ArrayList<>();

        if (index == nums.length || nums[index] * k > target || target > nums[nums.length - 1] * k) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, index);
        }

        for (int i = index; i < nums.length; i++) {
            // avoid duplicate
            if (i == index || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    // important part
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }

        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int index) {

        List<List<Integer>> res = new ArrayList<>();

        int left = index;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            // avoid duplicate
            if (sum > target || (right < nums.length - 1 && nums[right] == nums[right + 1])) {
                right--;
            // avoid duplicate
            } else if (sum < target || (left > index && nums[left - 1] == nums[left])) {
                left++;
            } else {
                res.add(Arrays.asList(nums[left], nums[right]));
                left++;
                right--;
            }
        }

        return res;
    }
}
