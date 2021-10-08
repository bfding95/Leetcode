package string;

/**
 * date 2021/10/7
 * problem：https://leetcode.com/problems/zigzag-conversion/
 */

/*
    Solution:
        Loop: 2 * numRows - 2 = loop
        row 0: k * loop
        row numRows - 1: k * loop + numRows - 1
        row i: k * loop + i and k * loop + loop - i
 */
public class zigZagConversion {

    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int len = 2 * numRows - 2;
        // i stand for row
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j += len) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + len - i < s.length()) {
                    sb.append(s.charAt(j + len - i));
                }
            }
        }

        return sb.toString();
    }
}
