// https://leetcode.com/problems/valid-anagram/

public class LC_242 {
    public static boolean isAnagram(String s, String t) {
        // If the strings are not equal, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Making two frequency arrays for all the lowercase alphabets
        int[] sFreq = new int[26];
        int[] tFreq = new int[26];

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        for (int i = 0; i < sArr.length; i++) {
            // Mapping and adding the frequency of the characters
            sFreq[sArr[i] - 'a']++;
            tFreq[tArr[i] - 'a']++;
        }

        // If the frequencies are different at any point, the strings are not anagrams
        for (int i = 0; i < 26; i++) {
            if (tFreq[i] != sFreq[i])
                return false;
        }

        // If no false clauses took off, the string is an anagram
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
}
