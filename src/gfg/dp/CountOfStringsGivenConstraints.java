package gfg.dp;

//http://www.geeksforgeeks.org/count-strings-can-formed-using-b-c-given-constraints/
//        Given a length n, count the number of strings of length n that can be made using ‘a’, ‘b’ and ‘c’ with at-most one ‘b’ and two ‘c’s allowed.
//
//        Examples:
//
//        Input : n = 3
//        Output : 19
//        Below strings follow given constraints:
//        aaa aab aac aba abc aca acb acc baa
//        bac bca bcc caa cab cac cba cbc cca ccb
//
//        Input  : n = 4
//        Output : 39
//        Asked in Google Interview

public class CountOfStringsGivenConstraints {
    public static int countStr(int n, int maxbCount, int maxcCount) {
        if (maxbCount < 0 || maxcCount < 0) {
            return 0;
        } else if (maxbCount == 0 && maxcCount == 0) {
            return 1;
        } else if (n == 0) {
            return 1;
        }

        int res = 0;
        res += countStr(n - 1, maxbCount, maxcCount);
        res += countStr(n - 1, maxbCount - 1, maxcCount);
        res += countStr(n - 1, maxbCount, maxcCount - 1);
        return res;
    }

    public static int countStrWithDp(int n, int maxbCount, int maxcCount) {
        int[][][] dp = new int[n + 1][maxbCount + 1][maxcCount + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxbCount; j++) {
                for (int k = 0; k <= maxcCount; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return countStrWithDpUtil(dp, n, maxbCount, maxcCount);
    }

    public static int countStrWithDpUtil(int[][][] dp, int n, int maxbCount, int maxcCount) {
        if (maxbCount < 0 || maxcCount < 0) {
            return 0;
        } else if (maxbCount == 0 && maxcCount == 0) {
            return 1;
        } else if (n == 0) {
            return 1;
        }

        if (dp[n][maxbCount][maxcCount] != -1) {
            return dp[n][maxbCount][maxcCount];
        }

        int res = 0;
        res += countStr(n - 1, maxbCount, maxcCount);
        res += countStr(n - 1, maxbCount - 1, maxcCount);
        res += countStr(n - 1, maxbCount, maxcCount - 1);

        dp[n][maxbCount][maxcCount] = res;
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int num = countStr(n, 1, 2);
        int num2 = countStrWithDp(n, 1, 2);
        System.out.println(num);
        System.out.println(num2);
    }
}
