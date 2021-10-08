package string;

import java.util.HashMap;

/**
 * date 2021/10/7
 * problem：https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

/*
    Solution: sliding window
    go through on right index and use a hashMap to record the number of characters
 */
public class longestSubStringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int max = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {

            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r, 0) + 1);
            while (map.get(r) > 1) {
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1);
                left++;
            }
            max = Math.max(right - left + 1, max);
            right++;
        }

        return max;
    }
}
