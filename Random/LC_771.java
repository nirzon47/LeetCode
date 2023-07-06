// https://leetcode.com/problems/jewels-and-stones/

public class LC_771 {
    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        // Making a frequency array that can hold both uppercase and lowercase operators
        boolean[] freq = new boolean['z' + 1];
        for (char ch : jewels.toCharArray()) {
            // Putting true for all characters that exists in jewels
            freq[ch] = true;
        }

        for (char ch : stones.toCharArray()) {
            // If the character in stone exists in our frequency array, we increase our count
            if (freq[ch]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbbbbb"));
    }
}
