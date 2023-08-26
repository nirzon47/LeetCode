// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

public class LC_28 {
    public static int strStr(String haystack, String needle) {
        // Taking the lengths of the strings
        int len = needle.length();
        int haystackLen = haystack.length();

        // If haystack is smaller than needle, there will not be any answers
        if (len > haystackLen) {
            return -1;
        }

        // Iterating through haystack - needle's size
        for (int i = 0; i <= haystackLen - len; i++) {
            // If the first character of needle matches with the current character in haystack,
            // We check the rest of the needle's length
            if (haystack.charAt(i) == needle.charAt(0)) {
                int ptr = 0;

                // If all the characters are equal, our ptr should be equal to the needle's length
                while (ptr < len && haystack.charAt(i + ptr) == needle.charAt(ptr)) {
                    ptr++;
                }

                // So if they are equal, we return the index
                if (ptr == len) {
                    return i;
                }
            }
        }

        // If there are no matches, we return -1
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
    }
}
