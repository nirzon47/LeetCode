// https://leetcode.com/problems/count-the-number-of-consistent-strings/

public class LC_1684 {
    public static int countConsistentStrings(String allowed, String[] words) {
        // Making an array that checks if a character is present in 'allowed'
        boolean[] exists = new boolean[26];
        // count counts the number of consistent strings
        int count = 0;

        for (int i = 0; i < allowed.length(); i++) {
            exists[allowed.charAt(i) - 'a'] = true;
        }

        for (String word : words) {
            boolean isConsistent = true;
            for (int i = 0; i < word.length(); i++) {
                // If a character does not exist in the allowed string, we make our boolean flag, false and break
                if (!exists[word.charAt(i) - 'a']) {
                    isConsistent = false;
                    break;
                }
            }

            // If our flag is true, we increase our count of consistent string
            if (isConsistent) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
    }
}
