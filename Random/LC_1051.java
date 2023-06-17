import java.util.*;

public class LC_1051 {

    public static int heightChecker(int[] heights) {

        int[] freq = new int[101];

        for (int height : heights) {
            freq[height]++;
        }

        int res = 0, i = 0;

        for (int height : heights) {
            while (freq[i] == 0) i++;

            if (i != height) res++;

            freq[i]--;
        }

        return res;

        /*
        TC O(n)
        SC O(n)

        int len = heights.length, i = 0, count = 0;
        int[] expected = new int[len];

        for (int height : heights) {
            expected[i++] = height;
        }

        Arrays.sort(expected);
        i = 0;
        for (int height : heights) {
            if (expected[i++] != height) count++;
        }

        return count;
         */

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 1, 3};

        System.out.println(heightChecker(nums));
    }
}
