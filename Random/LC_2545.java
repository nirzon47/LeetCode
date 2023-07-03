// https://leetcode.com/problems/sort-the-students-by-their-kth-score/

import java.util.*;

public class LC_2545 {
    /*
    public static void swap(int[][] score, int pointer, int i) {
        for (int j = 0; j < score[0].length; j++) {
            int temp = score[pointer][j];
            score[pointer][j] = score[i][j];
            score[i][j] = temp;
        }
    }
    */

    public static int[][] sortTheStudents(int[][] score, int k) {
        /*
        This is pretty unnecessary if we use comparators

        int pointer = 0, n = score.length;
        Integer[] maxList = new Integer[n];
        for (int i = 0; i < n; i++) {
            maxList[i] = score[i][k];
        }

        Arrays.sort(maxList, (o1, o2) -> o2 - o1);

        while (pointer < n) {
            for (int i = 0; i < n; i++) {
                if (score[i][k] == maxList[pointer]) {
                    swap(score, pointer, i);
                    pointer++;
                    break;
                }
            }
        }

        return score;

         */

        // Sort the array according to the kth column in descending order
        Arrays.sort(score, (o1, o2) -> o2[k] - o1[k]);
        return score;
    }

    public static void main(String[] args) {
        int[][] matrix = {{10, 6, 9, 1}, {7, 5, 11, 2}, {4, 8, 3, 15}};
        int k = 2;

        matrix = sortTheStudents(matrix, k);

        for (int[] r : matrix) {
            for (int e : r) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
