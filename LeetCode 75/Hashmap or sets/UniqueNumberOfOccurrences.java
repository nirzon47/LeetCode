import java.util.*;

public class UniqueNumberOfOccurrences {

    public static boolean uniqueOccurrences(int[] arr) {

        // Taking a map that stores the frequency of the array's elements
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Putting the values of the map in a set to remove duplicates
        Set<Integer> set = new HashSet<>(map.values());

        // If the size of the set is the same as the size of the map, then it means that the frequencies are all unique
        return set.size() == map.size();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};

        System.out.println(uniqueOccurrences(arr));
    }
}
