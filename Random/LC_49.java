// https://leetcode.com/problems/group-anagrams/

import java.util.*;

public class LC_49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        /*
         * We make a map that has the key of the sorted string
         * If we find a similar string in the array after sorting, we add
         * the string to the key because they are anagrams
         * Later we return a list of the map's values since it stores the collection of all the anagrams
         */
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Converting the string into a char array and then sorting it
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            // Turning it back to a string, so we can work with it as a key
            String word = new String(chars);

            // If the key does not exist, we initialize a key-value pair, with value being a new List
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            // Add the word to the key
            map.get(word).add(s);
        }

        // Returns the map's value after converting it to a list
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
