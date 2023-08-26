// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;

public class LC_347 {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        // Making a map and tracking the frequency of each element
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Making a max heap that is based on the frequency (the values for the map)
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));

        for (int key : map.keySet()) {
            heap.add(key);
        }

        // Putting k elements in the res array
        int i = 0;
        while (k-- > 0) {
            res[i++] = heap.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
