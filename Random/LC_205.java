// https://leetcode.com/problems/isomorphic-strings/

public class LC_205 {
    public static boolean isIsomorphic(String s, String t) {
        // Considering all ASCII characters and making a frequency array for the 2 strings
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            // Initially, the entire frequency array is 0
            // But once we have some entries, we check if the character is mapped to the same index or not
            if (freq1[chS] != freq2[chT]) {
                return false;
            }

            // Mapping the indexes when we get them
            freq1[chS] = i + 1;
            freq2[chT] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }
}
