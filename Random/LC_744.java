// https://leetcode.com/problems/find-smallest-letter-greater-than-target/

public class LC_744 {
    public static char nextGreatestLetter(char[] letters, char target) {
        /*
         * Taking our result as the first character, because in case
         * there are no characters that are
         * bigger than our target, the first character is the default answer
         */
        char res = letters[0];
        int left = 0, right = letters.length - 1;

        // Using binary search and finding the character that is just bigger than target
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // If our current character is less than or equal to the target, we do not consider it
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                // If there is a character that is bigger than our target,
                // we take a note of it and go in the lower
                // side to check if we have a closer match
                res = letters[mid];
                right = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'c';

        System.out.println(nextGreatestLetter(letters, target));
    }
}
