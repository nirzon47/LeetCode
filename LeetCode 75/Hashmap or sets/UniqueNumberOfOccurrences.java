import java.util.*;

public class UniqueNumberOfOccurrences {

    public static boolean uniqueOccurrences(int[] arr) {

        Arrays.sort(arr);
        int count = 1, len = arr.length;

        // If there are just 2 elements or fewer, we check if the first two elements are different,
        // if they are, it means both of them have the same count i.e., 1, so we return false
        if (len <= 2) {
            if (arr[0] != arr[1]) return false;
        }

        // Using a hashset and storing the count of each element
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 1; i < len - 1; i++) {
            if (arr[i] == arr[i - 1])
                count++;
            else {
                if (hs.contains(count)) // if similar length already exists, we return false
                    return false;
                hs.add(count);
                count = 1;
            }
        }

        // If all checks are passed, returns true
        return true;

        /*
        Somehow better in space complexity
        Arrays.sort(arr);

        int count = 1, len = arr.length;

        if (len <= 2) {
            if (arr[0] != arr[1]) return false;
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 1; i < len - 1; i++) {
            if (arr[i] == arr[i - 1])
                count++;
            else {
                if (hm.containsKey(count))
                    return false;
                hm.put(count, arr[i - 1]);
                count = 1;
            }
        }

        return true;
         */
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};

        System.out.println(uniqueOccurrences(arr));
    }
}
