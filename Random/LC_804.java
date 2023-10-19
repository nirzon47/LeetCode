// https://leetcode.com/problems/unique-morse-code-words/

import java.util.*;

public class LC_804 {
    public static int uniqueMorseRepresentations(String[] words) {
        // Mapping all the morse code in an array, 0 is 'a', 1 is 'b' and so on
        String[] morse = {
                ".-",
                "-...",
                "-.-.",
                "-..",
                ".",
                "..-.",
                "--.",
                "....",
                "..",
                ".---",
                "-.-",
                ".-..",
                "--",
                "-.",
                "---",
                ".--.",
                "--.-",
                ".-.",
                "...",
                "-",
                "..-",
                "...-",
                ".--",
                "-..-",
                "-.--",
                "--.."
        };

        // Making a set so we can have unique elements
        Set<String> set = new HashSet<>();

        // Iterating through the string array
        for (String s : words) {
            // Making a temporary StringBuilder in which we add the corresponding morse code
            StringBuilder temp = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                // Adding the morse codes for each letter
                char c = s.charAt(i);

                temp.append(morse[c - 'a']);
            }

            // Adding the word in morse in the set
            set.add(temp.toString());
        }

        // The number of unique arrangements is the number of elements inside the set
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
