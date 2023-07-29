// https://leetcode.com/problems/relative-ranks/

import java.util.*;

public class LC_506 {
    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        // Making a max heap which stores the indices according to its values
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> score[o2] - score[o1]);
        String[] res = new String[n];

        for (int i = 0; i < n; i++) {
            heap.offer(i);
        }

        // Our ranks start from 1
        int i = 1;
        while (!heap.isEmpty()) {
            // Taking the index with the largest value from the heap
            int idx = heap.poll();
            switch (i) {
                // For the first three ranks, we award medals
                case 1 -> res[idx] = "Gold Medal";
                case 2 -> res[idx] = "Silver Medal";
                case 3 -> res[idx] = "Bronze Medal";
                // For the rest, we replace with the rank in number
                default -> res[idx] = Integer.toString(i);
            }
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] score = {5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }
}
