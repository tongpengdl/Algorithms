package gfg.dp;

//http://www.geeksforgeeks.org/number-subsequences-string-divisible-n/
//        Given a string consisting of digits 0-9, count the number of subsequences in it divisible by m.
//
//        Examples:
//
//        Input  : str = "1234", n = 4
//        Output : 4
//        The subsequences 4, 12, 24 and 124 are
//        divisible by 4.
//
//        Input  : str = "330", n = 6
//        Output : 4
//        The subsequences 30, 30, 330 and 0 are
//        divisible by n.
//
//        Input  : str = "676", n = 6
//        Output : 3
//        The subsequences 6, 6 and 66
public class NumOfSubstringDivisible {
    public static int countDivisibleNaive(String s, int n) {
        return countDivisibleNaiveHelper(s, n, 0, 0);
    }

    public static int countDivisibleNaiveHelper(String s, int n, int idx, int rem) {
        if (idx == s.length()) {
            return rem == 0 ? 1 : 0;
        }

        int ans = 0;
        ans += countDivisibleNaiveHelper(s, n, idx + 1, rem);
        ans += countDivisibleNaiveHelper(s, n, idx + 1, (rem * 10 + s.charAt(idx) - '0') % n);
        return ans;
    }

    public static void main(String[] args) {
        String s = "676";
        int n = 6;
        //note that an empty string doesn't count into the result, so subtract this case.
        int res1 = countDivisibleNaive(s, n) - 1;
        int res2 = countDivisibleSubseq(s, n);
        System.out.println(res1);
        System.out.println(res2);
    }

    /*
     * Dynamic programming
     * dp[i][j] -- number of subsequence from 0 to i (can be inclusive or exclusive) whose remainder divided by n is j
     */
    public static int countDivisibleSubseq(String s, int n) {
        int[][] dp = new int[s.length()][n];
        dp[0][(s.charAt(0) - '0') % n]++;
        for (int i = 1; i < s.length(); i++) {
            dp[i][(s.charAt(i) - '0') % n]++;
            for (int j = 0; j < n; j++) {
                dp[i][j] += dp[i - 1][j];
                dp[i][(j * 10 + s.charAt(i) - '0') % n] += dp[i - 1][j];
            }
        }
        return dp[s.length() - 1][0];
    }
}
