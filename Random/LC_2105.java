// https://leetcode.com/problems/watering-plants-ii/

public class LC_2105 {
    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        // Double pointers and storing the capacity
        int aTemp = capacityA, bTemp = capacityB;
        int count = 0, left = 0, right = plants.length - 1;

        while (left <= right) {
            // When left and right are in the same position,
            // we check if the middle position value is more than both alice and bob,
            // we refill one more time and break. If not, we just break.
            if (left == right) {
                if (capacityA < plants[left] && capacityB < plants[left]) {
                    count++;
                }
                break;
            }
            // If Alice's plant needs more water, we refill
            if (plants[left] > capacityA) {
                count++;
                capacityA = aTemp;
            }
            // Alice waters her plant
            capacityA -= plants[left];

            // If Bob's plant needs more water, we refill
            if (plants[right] > capacityB) {
                count++;
                capacityB = bTemp;
            }
            // Bob waters his plant
            capacityB -= plants[right];

            // Both move on to their next plants
            left++;
            right--;

        }

        return count;
    }


    public static void main(String[] args) {
        int[] plants = {1, 2, 4, 4, 5};
        int capacityA = 6, capacityB = 5;

        System.out.println(minimumRefill(plants, capacityA, capacityB));
    }
}
