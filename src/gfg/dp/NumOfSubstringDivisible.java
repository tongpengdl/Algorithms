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
        String s = "1234";
        int n = 4;
        //note that an empty string doesn't count into the result, so subtract this case.
        int res1 = countDivisibleNaive(s, n) - 1;
        System.out.println(res1);
    }
}
