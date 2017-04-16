package gfg.dp;

//http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
//        Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
//
//        Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
//        Output:  True  //There is a subset (4, 5) with sum 9.
public class SubsetProblem {


    /**
     *
     * @param set : the given array
     * @param n : the size of the given array
     * @param sum : given target
     * @return boolean value indicate whether can find a sbuset with given sum
     *
     *
     * a) include the last elememnt, recur for n = n - 1
     * b) exclude the last element, recur for n = n - 1
     */
    private static boolean isSubsetSum(int[] set, int n, int sum) {
        if (sum == 0) {
            return true;
        } else if (n == 0) {
            return false;
        }

        if (set[n - 1] > sum) {
            return isSubsetSum(set, n - 1, sum);
        }

        return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }

    private static boolean isSubsetSumDP(int[] set, int n, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (set[i - 1] <= j) {
                    dp[i][j] |= dp[i - 1][j - set[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }

    private static boolean isSubsetSumDP2(int[] set, int n, int sum) {
        boolean[][] dp = new boolean[sum + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i <= sum; i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (set[j - 1] <= i) {
                    dp[i][j] |= dp[i - set[j - 1]][j - 1];
                }
            }
        }
        return dp[sum][n];
    }

    public static void main(String[] args) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 38;
        int n = set.length;
        boolean contains = isSubsetSum(set, n, sum);

        /*
         * Two DPs prove that whether sum is the first element in the dp array doesn't matter
         */
        boolean contains2 = isSubsetSumDP(set, n, sum);
        boolean contains3 = isSubsetSumDP2(set, n, sum);
        System.out.println(contains);
        System.out.println(contains2);
        System.out.println(contains3);
    }
}
