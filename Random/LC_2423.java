// https://leetcode.com/problems/remove-letter-to-equalize-frequency/

public class LC_2423 {
    public static boolean isEqual(int[] freq) {
        int check = 0;

        for (int n : freq) {
            // Ignoring characters with no frequencies
            if (n != 0) {
                if (check == 0) {
                    // If check is 0, we add some value to it since we take this
                    // value to compare to the rest of the array
                    check = n;
                } else if (check != n) {
                    // If there is a difference in frequencies, we return false
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean equalFrequency(String word) {
        // Hashing the string
        int[] freq = new int[26];

        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }

        // Traversing the word again, but now we are decreasing the frequency by one and check with the entire
        // hashed array. So if all of them match just by decreasing one frequency, we got a match.
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // Decreasing the frequency by 1
            freq[c - 'a']--;

            // If decreasing frequency made a perfect match, we return true
            if (isEqual(freq)) {
                return true;
            }

            // Re adding the frequency again
            freq[c - 'a']++;
        }

        // If it didn't return true before, it has to be false
        return false;
    }

    public static void main(String[] args) {
        System.out.println(equalFrequency("abcc"));

    }
}
