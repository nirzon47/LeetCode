// https://leetcode.com/problems/roman-to-integer/

public class LC_13 {
    public static int romanToInt(String s) {
        // res is our output, num is the current character in number form
        // prev is the previous number
        int res = 0, num = 0, prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                // We do a normal mapping with the roman literals with integer values for future access
                case 'I' -> num = 1;
                case 'V' -> num = 5;
                case 'X' -> num = 10;
                case 'L' -> num = 50;
                case 'C' -> num = 100;
                case 'D' -> num = 500;
                case 'M' -> num = 1000;
            }

            // If the previous number was larger than the current one, we subtract the current number from the result
            // This is for cases like CM, IV
            if (prev > num) {
                res -= num;
            } else {
                // Otherwise just add it in the result
                res += num;
            }

            // We add the current number in previous since for the next iteration it will be the previous
            prev = num;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
