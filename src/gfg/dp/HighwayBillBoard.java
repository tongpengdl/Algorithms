package gfg.dp;

//http://www.geeksforgeeks.org/highway-billboard-problem/
//        Consider a highway of M miles. The task is to place billboards on the highway such that revenue is maximized. The possible sites for billboards are given by number x1 < x2 < ….. < xn-1 < xn, specifying positions in miles measured from one end of the road. If we place a billboard at position xi, we receive a revenue of ri > 0. There is a restriction that no two billboards can be placed within t miles or less than it.
//
//        Note : All possible sites from x1 to xn are in range from 0 to M as need to place billboards on a highway of M miles.
//
//        Examples:
//
//        Input : M = 20
//        x[]       = {6, 7, 12, 13, 14}
//        revenue[] = {5, 6, 5,  3,  1}
//        t = 5
//        Output: 10
//        By placing two billboards at 6 miles and 12
//        miles will produce the maximum revenue of 10.
//
//        Input : M = 15
//        x[] = {6, 9, 12, 14}
//        revenue[] = {5, 6, 3, 7}
//        t = 2
//        Output : 18

public class HighwayBillBoard {
    public static int maxRevenue(int m, int[] x, int[] revenue, int n, int t) {
        int[] dp = new int[m + 1];
        int index = 0;
        for (int i = 1; i <= m; i++) {
            if (index < n) {
                if (x[index] != i) {
                    dp[i] = dp[i - 1];
                } else {
                    if (i <= t) {
                        dp[i] = Math.max(dp[i - 1], revenue[index]);
                    } else {
                        dp[i] = Math.max(dp[i - 1], dp[i - t - 1] + revenue[index]);
                    }
                    index++;
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {
        int m = 20;
        int[] x = {5, 7, 12, 13, 14};
        int[] revenue = {5, 6, 5, 3, 1};
        int n = revenue.length;
        int t = 5;

        int max = maxRevenue(m, x, revenue, n, t);
        System.out.println(max);
    }
}
