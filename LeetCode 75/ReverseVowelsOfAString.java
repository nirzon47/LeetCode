// https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&id=leetcode-75

import java.util.*;

public class ReverseVowelsOfAString {

    // Checks if the letter is not a vowel.
    public static boolean isNotVowel(char ch) {
        ch = Character.toLowerCase(ch);
        switch (ch) {
            case 'a', 'e', 'i', 'o', 'u' -> {
                return false;
            }
        }
        return true;
    }

    public static String reverseVowels(String s) {
        // Converting the String to a char array
        char[] chArr = s.toCharArray();
        int left = 0, right = chArr.length - 1;

        // Double pointer method, if the characters are not vowels, moves on to the next character
        // if the characters are vowels, swap them
        while (left < right) {
            if (isNotVowel(chArr[left])) {
                left++;
            } else if (isNotVowel(chArr[right])) {
                right--;
            } else {
                char temp = chArr[left];
                chArr[left] = chArr[right];
                chArr[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chArr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(reverseVowels(s));

    }
}
