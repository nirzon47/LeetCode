// https://leetcode.com/problems/valid-number/

public class LC_65 {
    public static boolean isNumber(String S) {
        boolean num = false, exp = false, sign = false, dec = false;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c >= '0' && c <= '9') {
                num = true;
            } else if (c == 'e' || c == 'E') {
                // If there are no numbers, and we found an exponent, the number is invalid
                if (exp || !num) {
                    return false;
                } else {
                    // Else we reset everything and mark exp as true
                    exp = true;
                    sign = false;
                    num = false;
                    dec = false;
                }
            } else if (c == '+' || c == '-') {
                // If a sign or number and a decimal point already existed, it's not a valid number
                if (sign || num || dec) {
                    return false;
                } else {
                    // Otherwise, we mark the sign as true
                    sign = true;
                }
            } else if (c == '.') {
                // If a decimal point or exponent already exists, the number is invalid
                if (dec || exp) {
                    return false;
                } else {
                    // Otherwise, we mark decimal as true
                    dec = true;
                }
            } else {
                // The character is invalid
                return false;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("e"));
    }
}
