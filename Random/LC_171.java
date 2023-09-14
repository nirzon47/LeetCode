// https://leetcode.com/problems/excel-sheet-column-number/

public class LC_171 {
    public static int titleToNumber(String columnTitle) {
        if (columnTitle == null) {
            return -1;
        }

        // Since 0 * 26 = 0, it will not be a problem in edge cases
        int res = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            // If we are in any character after 0th index, it means we have already passed all 26 combinations
            // the earlier character can offer, so we multiply with 26 first
            // and then add the character's value in digits
            res *= 26;
            res += columnTitle.charAt(i) - 'A' + 1;
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
}
