public class LC_696 {
    public static int countBinarySubstrings(String s) {
        // We are counting and storing the number of zeros and ones and then adding the
        // minimum between them and adding to our result
        int res = 0, prev = 0, curr = 1;

        for (int i = 1; i < s.length(); i++) {
            // If the elements are the same, we increase current
            if (s.charAt(i - 1) == s.charAt(i)) {
                curr++;
            } else {
                // Otherwise, we add the minimum between the previous and
                // current substrings and add it to the result
                res += Math.min(curr, prev);
                // Putting the current to previous for future
                prev = curr;
                // Resetting current to 1 because we already went over the new character in this iteration
                curr = 1;
            }
        }

        // We do it again because the last case won't be counted
        res += Math.min(curr, prev);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
    }
}
