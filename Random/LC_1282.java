// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

import java.util.*;

public class LC_1282 {
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        // Taking a hashmap that stores the values for its key and the indexes as a list in its value
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int len = groupSizes.length;

        for (int i = 0; i < len; i++) {
            int ele = groupSizes[i];

            // Accessing the list associated with the current element in the hashmap
            List<Integer> curr = map.getOrDefault(ele, new ArrayList<>());
            // Adding the index to it
            curr.add(i);
            // Putting it back in the map after updating it
            map.put(ele, curr);

            // If the index list's size is the same as the current value, we add the list to our result
            // Then remove the mapping
            if (curr.size() == ele) {
                res.add(curr);
                map.remove(ele);
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
        System.out.println(groupThePeople(groupSizes));
    }
}
