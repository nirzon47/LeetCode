public class LC_1898 {
    public static boolean isSubsequencePossible(char[] charS, char[] charP) {
        // Finding valid Subsequence using 2 pointers
        int p1 = 0, p2 = 0;
        int sLen = charS.length, pLen = charP.length;
        while (p1 < sLen && p2 < pLen) {
            // If the current character is, '.', we ignore it.
            // If the character is not a, '.', we increase p's pointer
            if (charS[p1] != '.' && charS[p1] == charP[p2]) {
                p2++;
            }
            // Unconditionally increase s's pointer
            p1++;
        }

        // If p2 reaches the end, we return true
        return p2 == pLen;
    }

    public static int maximumRemovals(String s, String p, int[] removable) {
        /*
         * Intuition:
         * We check for the part up to which we can remove the indices from removable[]
         * To do that, we use binary search
         * We take the middle of the range in removables and then replace the indices with a random value
         * Then send it to check if the char array's subsequence is p or not
         * If it is subsequence, we increase our range
         * Otherwise we decrease it and restore the changed indices
         */
        int left = 0, right = removable.length - 1;
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();

        while (left <= right) {
            int mid = left + (right - left) / 2;

            for (int i = 0; i <= mid; i++) {
                charS[removable[i]] = '.';
            }

            if (isSubsequencePossible(charS, charP)) {
                left = mid + 1;
            } else {
                for (int i = left; i <= mid; i++) {
                    charS[removable[i]] = s.charAt(removable[i]);
                }
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        String s = "abcacb", p = "ab";
        int[] removable = {3, 1, 0};

        System.out.println(maximumRemovals(s, p, removable));
    }
}
