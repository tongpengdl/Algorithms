package gfg.dp;

//http://www.geeksforgeeks.org/subset-sum-divisible-m/
//        Given a set of non-negative distinct integers, and a value m, determine if there is a subset of the given set with sum divisible by m.
//        Input Constraints
//        Size of set i.e., n <= 1000000, m <= 1000
//
//        Examples:
//
//        Input : arr[] = {3, 1, 7, 5};
//        m = 6;
//        Output : YES
//
//        Input : arr[] = {1, 6};
//        m = 5;
//        Output : NO

public class SubsetWithSum {

    /**
     *
     * @param arr
     * @param n
     * @param m
     * @return
     *
     * iterate through each element in arr.
     * a) consider current element: calculate modular, and set true in tmp
     * b) ignore current element: nothing to do
     */
    private static boolean modularSum(int[] arr, int n, int m) {
        //Pigionhole Princepal
        //https://en.wikipedia.org/wiki/Pigeonhole_principle#Subset_sum
        //a number divided by m has m possibilities -- 0, 1,...,m - 1
        //how to prove?

        //here is the anwser:
        /**
         * Suppose m = 5, and arr contains five elements, and each element mod by 5 must less than 5,
         * so the problem transformed to prove that we have 5 elements who are less than 5, and there exists a
         * subset, whose sum is divisible by 5
         *
         */
        if (n > m) {
            return true;
        }

        boolean[] dp = new boolean[m];
        for (int i = 0; i < n; i++) {
            if (dp[0]) {
                return true;
            }

            boolean[] tmp = new boolean[m];
            for (int j = 0; j < m; j++) {
                if (dp[j]) {
                    tmp[(j + arr[i]) % m] = true;
                }
            }

            for (int k = 0; k < m; k++) {
                if (tmp[k]) {
                    dp[k] = true;
                }
            }

            dp[arr[i] % m] = true;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 7};
        boolean exist = modularSum(arr, 2, 5);
        System.out.println(exist);
    }

}
