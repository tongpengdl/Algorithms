package gfg.dp;

//http://www.geeksforgeeks.org/finding-the-maximum-square-sub-matrix-with-all-equal-elements/
//        Given a N x N matrix, determine the maximum K such that K x K is a submatrix with all equal elements i.e., all the elements in this submatrix must be same.
//
//        Constraints:
//        1 <= N <= 1000
//        0 <= Ai , j <= 109
//
//        Examples:
//
//
//        Input : a[][] = {{2, 3, 3},
//        {2, 3, 3},
//        {2, 2, 2}}
//        Output : 2
//        Explanation: A 2x2 matrix is formed from index
//        A0,1 to A1,2
//
//        Input : a[][]  = {{9, 9, 9, 8},
//        {9, 9, 9, 6},
//        {9, 9, 9, 3},
//        {2, 2, 2, 2}
//        Output : 3
//        Explanation : A 3x3 matrix is formed from index
//        A0,0 to A2,2

public class FindSumMatrixWithEqualSum {
    public static int largestKSubmatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 1;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    if (matrix[i][j] == matrix[i - 1][j] &&
                            matrix[i][j] == matrix[i][j - 1] &&
                            matrix[i][j] == matrix[i - 1][j - 1]) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = { {2, 2, 3, 3, 4, 4},
                {5, 5, 7, 7, 7, 4},
                {1, 2, 7, 7, 7, 4},
                {4, 4, 7, 7, 7, 4},
                {5, 5, 5, 1, 2, 7},
                {8, 7, 9, 4, 4, 4}
        };

        int max = largestKSubmatrix(matrix);
        System.out.println(max);

    }
}
