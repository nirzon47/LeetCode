// https://leetcode.com/problems/string-to-integer-atoi/

public class LC_8 {
    public static int myAtoi(String str) {
        int index = 0;
        int total = 0;
        int sign = 1;

        // If the string is empty, we return 0
        if (str.isEmpty()) {
            return 0;
        }

        // Trimming the spaces until we get a non-space character
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }

        // If the index reaches the end, we return 0 again because there is nothing but spaces
        if (index == str.length()) {
            return 0;
        }

        // Taking the sign
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < str.length()) {
            int digit = str.charAt(index) - '0';

            // If our character is not a digit, we terminate the loop
            if (digit < 0 || digit > 9) break;

            // Checking if the number we have is more than the integer limit, if it is, we return the min or max
            // value depending on the sign
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Otherwise, we make the total
            total = total * 10 + digit;
            index++;
        }

        // Returning the total with the sign
        return total * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("   -42"));
    }
}
