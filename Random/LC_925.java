// https://leetcode.com/problems/long-pressed-name/

public class LC_925 {
    public static boolean isLongPressedName(String name, String typed) {
        int nLen = name.length(), tLen = typed.length();
        // Taking two pointers
        int n = 0, t = 0;

        while (n < nLen && t < tLen) {
            // If the characters are same, we move both the pointers
            if (name.charAt(n) == typed.charAt(t)) {
                n++;
                t++;
            } else if (n > 0 && name.charAt(n - 1) == typed.charAt(t)) {
                // If the last character from name string is equal to the current character on
                // typed string, we move type's pointer
                t++;
            } else {
                // Meaning we have a mismatch in the characters, so we return false
                return false;
            }
        }

        // There is a chance that the typed string is not fully iterated over
        while (t < tLen) {
            // We check if the last character of name is equal to the current character in typed
            if (name.charAt(n - 1) == typed.charAt(t)) {
                t++;
            } else {
                return false;
            }
        }

        // If we have not reached the end of the string for name string,
        // it means typed does not have all the characters,
        // So we return false if the lengths are not the same
        return n == nLen;
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaaleeex"));
    }
}
