import java.util.*;

public class FindTheDifferenceBetweenTwoArrays {

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> n1 = new HashSet<>();
        HashSet<Integer> n2 = new HashSet<>();
        for (int num1 : nums1) {
            n1.add(num1);
        }
        for (int num2 : nums2) {
            n2.add(num2);
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        for (int n : n1) {
            if (!n2.contains(n)) {
                res.get(0).add(n);
            }
        }

        for (int n : n2) {
            if (!n1.contains(n)) {
                res.get(1).add(n);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};

        System.out.println(Arrays.toString(findDifference(nums1, nums2).toArray()));
    }
}
