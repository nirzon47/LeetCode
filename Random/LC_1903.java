// https://leetcode.com/problems/largest-odd-number-in-string/

public class LC_1903 {
    public static String largestOddNumber(String num) {
        // Checking from the back if a number is odd or even
        // If it is the odd, the remaining number is the largest odd
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }

        // Return blank string is the number is even
        return "";
    }

    public static void main(String[] args) {
        System.out.println(largestOddNumber("35427"));
    }
}
