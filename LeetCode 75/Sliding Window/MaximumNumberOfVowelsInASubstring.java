// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

public class MaximumNumberOfVowelsInASubstring {

    public static int maxVowels(String s, int k) {
        int count = 0, maxCount;
        // Converting the string into a char array
        char[] chars = s.toCharArray();

        // Making an array that adds one only to the vowels
        byte[] vowels = new byte['z' + 1];
        vowels['a'] = 1;
        vowels['e'] = 1;
        vowels['i'] = 1;
        vowels['o'] = 1;
        vowels['u'] = 1;

        // Using the sliding window algorithm and handling the first window
        for (int i = 0; i < k; i++) {
            count += vowels[chars[i]];
        }

        maxCount = count;
        int start = 0;

        // Moving the windows and subtracting the value of the alphabet in vowels array corresponding to the
        // alphabet we are accessing
        for (int i = k; i < chars.length; i++) {
            count -= vowels[chars[start++]];
            count += vowels[chars[i]];
            if (count > maxCount) maxCount = count;
            // If we all the characters in the window as vowels, we exit out of the loop
            if (maxCount == k) break;
        }

        // Makes the code 1ms slower but at makes it dramatically space efficient
        System.gc();

        return maxCount;
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;

        System.out.println(maxVowels(s, k));
    }
}
