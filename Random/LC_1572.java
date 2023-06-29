public class LC_1572 {
    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        int len = mat.length;

        for (int i = 0, j = len - 1; i < len && j >= 0; i++, j--) {
            sum += mat[i][i];
            if (i != j)
                sum += mat[i][j];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(diagonalSum(matrix));
    }
}
