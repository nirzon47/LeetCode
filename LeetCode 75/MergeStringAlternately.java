// https://leetcode.com/problems/merge-strings-alternately/

import java.util.*;

public class MergeStringAlternately {

    public static String mergeAlternately(String word1, String word2) {
        // Putting the lengths of the words in variables for future use
        int len1 = word1.length();
        int len2 = word2.length();

        StringBuilder res = new StringBuilder();

        // Appending both strings' characters' in each iteration until we cover all of them until the smaller string and then appending the rest.
        if (len1 > len2) {
            for (int i = 0; i < len2; i++) {
                res.append(word1.charAt(i)).append(word2.charAt(i));
            }
            res.append(word1, len2, len1);
        } else {
            for (int i = 0; i < len1; i++) {
                res.append(word1.charAt(i)).append(word2.charAt(i));
            }
            res.append(word2, len1, len2);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();

        System.out.println(mergeAlternately(word1, word2));
    }
}