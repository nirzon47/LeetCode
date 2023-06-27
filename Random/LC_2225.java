// https://leetcode.com/problems/find-players-with-zero-or-one-losses/

import java.util.*;

public class LC_2225 {
    public static List<List<Integer>> findWinners(int[][] matches) {

        // Taking a map and the result list
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> lost = new HashMap<>();

        // Putting all the entries that won and assigning them
        // as zero since win count does not matter
        for (int[] match : matches) {
            lost.put(match[0], 0);
        }

        // Counting the number of times, an entry has lost
        for (int[] match : matches) {
            lost.put(match[1], lost.getOrDefault(match[1], 0) + 1);
        }

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        // If the map points to 0 and 1, add them to their designated lists
        for (int l : lost.keySet()) {
            if (lost.get(l) == 0) {
                l1.add(l);
            } else if (lost.get(l) == 1) {
                l2.add(l);
            }
        }

        // Sort the results because the question wants us to
        Collections.sort(l1);
        Collections.sort(l2);

        // Add the lists in the result list
        res.add(l1);
        res.add(l2);
        
        return res;

    }

    public static void main(String[] args) {
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};

        System.out.println(findWinners(matches));
    }
}
