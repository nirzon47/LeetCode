// https://leetcode.com/problems/furthest-building-you-can-reach/description/

import java.util.*;

public class LC_1642 {
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Taking a max heap because we are storing the stacks of bricks we use per building,
        // and we want the biggest stack to replace the ladders
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int n = heights.length - 1;

        for (int i = 0; i < n; i++) {
            // If the next building is smaller, we do nothing at all
            if (heights[i] >= heights[i + 1]) {
                continue;
            }

            // Otherwise, we take some bricks to cover the height
            int diff = heights[i + 1] - heights[i];
            bricks -= diff;
            // We also put the stack of bricks we used in the max heap
            heap.offer(diff);

            // If we run out of bricks, we put the max stack to our remaining bricks again,
            // but for that we use a ladder to make the jump
            // if there are no ladders, that is our last building, and we return that
            if (bricks < 0) {
                bricks += heap.poll();
                if (ladders > 0) {
                    ladders--;
                } else {
                    return i;
                }
            }
        }

        // If the code does not exit before, all the buildings were covered
        return n;
    }

    public static void main(String[] args) {
        int[] heights = {4, 2, 7, 6, 9, 14, 12};
        int bricks = 5, ladders = 1;

        System.out.println(furthestBuilding(heights, bricks, ladders));

    }
}
