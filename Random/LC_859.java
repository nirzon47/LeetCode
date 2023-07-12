// https://leetcode.com/problems/buddy-strings/

import java.util.*;

public class LC_859 {
    public static boolean buddyStrings(String s, String goal) {
        // If we have strings with 2 different lengths, of course we cannot have buddy strings
        if (s.length() != goal.length()) {
            return false;
        }
        // If we have an equal string, then we have to find any character that occurs twice,
        // so we can swap them in order to satisfy our buddy string condition
        if (s.equals(goal)) {
            // Creating a set to remove any duplicates
            HashSet<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                set.add(c);
            }

            // If the size of the set is the same as the goal string,
            // then that means that there are no duplicates to be removed,
            // and we don't have buddy strings
            return goal.length() > set.size();
        }

        // Making 2 pointers, one that stops when the characters are not equal from the beginning,
        // and another that stops when the characters are not equal from the end
        // If we swap them and our string is equal to goal, we win
        int left = 0;
        int right = s.length() - 1;

        // Checking for the first character that is not equal
        while (left < right && s.charAt(left) == goal.charAt(left)) {
            left++;
        }

        // Checking for the last character that is not equal
        while (right >= 0 && s.charAt(right) == goal.charAt(right)) {
            right--;
        }

        // If the first pointer is not smaller than the second pointer, we can't swap or
        // there are no 2 different characters that we can swap
        if (left < right) {
            // Swapping
            char[] sArr = s.toCharArray();
            char temp = sArr[left];
            sArr[left] = sArr[right];
            sArr[right] = temp;
            s = new String(sArr);
        }

        // If the strings are equal after swapping, we return true, otherwise false
        return s.equals(goal);

    }

    public static void main(String[] args) {
        String s = "ab";
        String goal = "ba";

        System.out.println(buddyStrings(s, goal));
    }
}
