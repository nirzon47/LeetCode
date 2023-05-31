// https://leetcode.com/problems/greatest-common-divisor-of-strings/

import java.util.*;

public class GreatestCommonDivisorOfStrings {

    // Finding GCD of the two lengths using recursion
    public static int GCD(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return GCD(y, x % y);
        }
    }

    public static String gcdOfStrings(String str1, String str2) {

        // Checking if both the strings have no GCD cases
        if (!(str1 + str2).equals(str2 + str1))
            return "";

        // Finding the GCD between the length of the strings
        int gcdLength = GCD(str1.length(), str2.length());

        // Returning the string up to the GCD of the two strings
        return str1.substring(0, gcdLength);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        System.out.println(gcdOfStrings(str1, str2));
    }
}
