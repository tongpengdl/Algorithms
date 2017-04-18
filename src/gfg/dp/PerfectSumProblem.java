package gfg.dp;

//http://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/
//        Given an array of integers and a sum, the task is to print all subsets of given array with sum equal to given sum.
//
//        Examples:
//
//        Input : arr[] = {2, 3, 5, 6, 8, 10}
//        sum = 10
//        Output : 5 2 3
//        2 8
//
//        Input : arr[] = {1, 2, 3, 4, 5}
//        sum = 10
//        Output : 4 3 2 1
//        5 3 2
//        5 4 1

import java.util.ArrayList;
import java.util.List;

public class PerfectSumProblem {
    public static List<List<Integer>> printAllSubsets(int[] arr, int n, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || sum < 0) {
            return res;
        }

        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (arr[i - 1] <= j) {
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        if (!dp[n][sum]) {
            return res;
        }

        printSubsetRec(arr, 0, sum, new ArrayList<Integer>(), res, dp);
        return res;
    }

    // use dp here to prone. if current sum cannot be get from the rest of the array, simply terminate the recursion
    public static void printSubsetRec(int[] arr, int i, int sum, List<Integer> tmp, List<List<Integer>> res, boolean[][] dp) {
        if (i > arr.length || i == arr.length && sum != 0) {
            return;
        }

        if (i == arr.length && sum == 0) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }

        if (!dp[arr.length][sum]) {
            return;
        }

        printSubsetRec(arr, i + 1, sum, tmp, res, dp);

        tmp.add(arr[i]);
        printSubsetRec(arr, i + 1, sum - arr[i], tmp, res, dp);
        tmp.remove(tmp.size() - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = 5;
        int sum = 10;
        List<List<Integer>> res = printAllSubsets(arr, n, sum);
        System.out.println(res.toString());
    }
}
