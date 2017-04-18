package gfg.dp;

//http://www.geeksforgeeks.org/largest-sum-zig-zag-sequence-in-a-matrix/
//        Given a matrix of size n x n, find sum of the Zigzag sequence with the largest sum. A zigzag sequence starts from the top and ends at the bottom. Two consecutive elements of sequence cannot belong to same column.
//        Examples:
//
//        Input : mat[][] = 3  1  2
//        4  8  5
//        6  9  7
//        Output : 18
//        Zigzag sequence is: 3->8->7
//        Another such sequence is 2->4->7
//
//        Input : mat[][] =  4  2  1
//        3  9  6
//        11  3 15
//        Output : 28

import java.util.Arrays;

public class LargestSumZigzag {

//    Maximum Zigzag sum starting from arr[i][j] to a
//    bottom cell can be written as :
//    zzs(i, j) = arr[i][j] + max(zzs(i+1, k)),
//    where k = 0, 1, 2 and k != j
//    zzs(i, j) = arr[i][j], if i = n-1
//
//    We have to find the largest among all as
//    Result = zzs(0, j) where 0 <= j < n
    public static int largestZigZagSumRec(int[][] matrix, int n) {
        int res = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.max(res, largetZigZagSumRecUtil(matrix, n, 0, j));
        }
        return res;

    }

    public static int largetZigZagSumRecUtil(int[][] matrix, int n, int i, int j) {
        if (i == n - 1) {
            return matrix[i][j];
        }

        int ret = matrix[i][j];
        int max = Integer.MIN_VALUE;
        for (int k = 0; k < n; k++) {
            if (k == j) {
                continue;
            }
            max = Math.max(max, largetZigZagSumRecUtil(matrix, n, i + 1, k));
        }

        ret += max;
        return ret;
    }

    public static int largestZigZagSumMem(int[][] matrix, int n) {
        int[][] mem = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mem[i], -1);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, largetZigZagSumMemUtil(matrix, n, 0, i, mem));
        }
        return res;
    }

    public static int largetZigZagSumMemUtil(int[][] matrix, int n, int i, int j, int[][] mem) {
        if (i == n - 1) {
            return matrix[i][j];
        }

        if (mem[i][j] != -1) {
            return mem[i][j];
        }

        int ret = Integer.MIN_VALUE;
        for (int k = 0; k < n; k++) {
            if (k == j) {
                continue;
            }

            ret = Math.max(ret, largetZigZagSumMemUtil(matrix, n, i + 1, k, mem));
        }

        ret += matrix[i][j];
        mem[i][j] = ret;
        return ret;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = { {4, 2, 1},
                {3, 9, 6},
                {11, 3, 15}};
        int sum = largestZigZagSumRec(matrix, n);
        int sum2 = largestZigZagSumMem(matrix, n);
        System.out.println(sum);
        System.out.println(sum2);
    }
}
