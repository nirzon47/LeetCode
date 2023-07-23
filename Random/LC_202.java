// https://leetcode.com/problems/happy-number/

import java.util.*;

public class LC_202 {
    public static int findSquare(int n) {
        // Standard way of taking digits apart
        int res = 0;
        while (n > 0) {
            int digit = n % 10;
            res += digit * digit;
            n /= 10;
        }

        return res;
    }

    public static boolean isHappy(int n) {
        // Set to avoid duplicates in case we are repeating our operation over and over
        Set<Integer> set = new HashSet<>();

        // If the set adds the number, it will return true, otherwise it will return false
        while (set.add(n)) {
            // If n is 1, we have a happy number, so we return true
            if (n == 1) {
                return true;
            } else {
                // If it is not 1, we find the square of its digits again and put it in our new n
                n = findSquare(n);
            }
        }
        // Loop ends as soon as we get a duplicate, meaning our number can never be happy :(

        // If we don't get a happy number up there, it has to be a sad number so returning false
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
