// https://leetcode.com/problems/assign-cookies/

import java.util.*;

public class LC_455 {
    public static int findContentChildren(int[] g, int[] s) {
        // Sorting both arrays so we start from the minimum values
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;

        // Initializing 2 pointers at the start of the arrays
        int child = 0, cookie = 0;

        while (child < g.length && cookie < s.length) {
            // Pointers go until we are out of bounds
            // If the cookie satisfies a child, we give it to them and
            // move on to the next child and cookie
            if (s[cookie] >= g[child]) {
                count++;
                cookie++;
                child++;
            } else {
                // A bigger cookie is needed
                cookie++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3}, s = {1, 1};

        System.out.println(findContentChildren(g, s));
    }
}