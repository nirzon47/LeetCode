// https://leetcode.com/problems/sqrtx/

public class LC_69 {
    public static int mySqrt(int x) {
        // If the number is 0, we just return 0
        if (x == 0) {
            return 0;
        }

        // Taking two pointers and applying binary search
        int left = 1, right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                // If mid is equal to x / mid, we found our result
                return mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }


    public static void main(String[] args) {
        System.out.println(mySqrt(16));
    }
}
