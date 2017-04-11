package gfg.dp;

//http://www.geeksforgeeks.org/modify-array-to-maximize-sum-of-adjacent-differences/
//        Given an array, we need to modify values of this array in such a way that sum of absolute differences between two consecutive elements is maximized. If the value of an array element is X, then we can change it to either 1 or X.
//        Examples:
//
//        Input  : arr[] = [3, 2, 1, 4, 5]
//        Output : 8
//        We can modify above array as,
//        Modified arr[] = [3, 1, 1, 4, 1]
//        Sum of differences =
//        |1-3| + |1-1| + |4-1| + |1-4| = 8
//        Which is the maximum obtainable value
//        among all choices of modification.
//
//        Input  : arr[] = [1, 8, 9]
//        Output :14

//assembly line scheduling
//why 2 array? each element has 2 states -- 1 or X
public class MaximizeSum {
   public static int maximumDifferenceSum(int[] arr) {
       int n = arr.length;
       int[][] dp = new int[n][2];

       for (int i = 1; i < n; i++) {
           dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + Math.abs(1 - arr[i - 1]));
           dp[i][1] = Math.max(dp[i - 1][0] + Math.abs(arr[i] - 1), dp[i - 1][1] + Math.abs(arr[i] - arr[i - 1]));
       }

       return Math.max(dp[n - 1][0], dp[n - 1][1]);
   }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 5};
        int diff = maximumDifferenceSum(arr);
        System.out.println(diff);
    }

}
