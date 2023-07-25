// https://leetcode.com/problems/reverse-integer/

public class LC_7 {
    public static int reverse(int x) {
        int reverse = 0;

        while (x != 0) {
            // Our integer cannot exceed 9 bits, normally Integer.MAX_VALUE and Integer.MIN_VALUE
            // has 10 bits, and if we do operations on that, it exceeds our environment limit.
            /*
             * We need to look at the max value of int which is 2147483647 (2^31-1).
             * We can then see that when we are adding the 10th digit and the first 9 exceed 214748364,
             * then no matter what the 10th digit will be, the number will be larger than the max int value.
             * But if the first 9 digits are no more than 214748364,
             * then the 10th digit can be in the range [0, 7].
             */

            if (reverse > 214748364 || reverse < -214748364) {
                return 0;
            }

            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
