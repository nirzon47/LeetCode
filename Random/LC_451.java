// https://leetcode.com/problems/sort-characters-by-frequency/

import java.util.*;

public class LC_451 {
    public static String frequencySort(String s) {
        // Hashing the string
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Making a max heap that stores the characters according to their
        // values, i.e., their frequencies
        PriorityQueue<Character> heap;
        heap = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        heap.addAll(map.keySet());

        StringBuilder res = new StringBuilder();
        while (!heap.isEmpty()) {
            // Taking the maximum occurring character and adding it to the result
            // according to their frequencies
            char c = heap.poll();
            for (int i = 0; i < map.get(c); i++) {
                res.append(c);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
