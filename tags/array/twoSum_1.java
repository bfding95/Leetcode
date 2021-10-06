import java.util.Arrays;
import java.util.HashMap;

/**
 * date 2021/10/5
 * problem: https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

class twoSum_1 {

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {i, map.get(nums[i])};
            }
            map.put(target - nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,4,5,6,7};

        int[] result = twoSum(nums, 3);

        System.out.println(Arrays.toString(result));
    }
}