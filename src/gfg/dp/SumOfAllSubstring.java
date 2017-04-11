package gfg.dp;


//http://www.geeksforgeeks.org/sum-of-all-substrings-of-a-string-representing-a-number/
//        Given a integer represented as a string, we need to get the sum of all possible substrings of this string.
//
//        Examples:
//
//        Input  : num = “1234”
//        Output : 1670
//        Sum = 1 + 2 + 3 + 4 + 12 + 23 +
//        34 + 123 + 234 + 1234
//        = 1670
//
//        Input  : num = “421”
//        Output : 491
//        Sum = 4 + 2 + 1 + 42 + 21 + 421
//        = 491

/**
 * sumofdigit[i]  =  (i+1)*num[i] + 10*sumofdigit[i-1]
 * Where sumofdigit[i] stores sum of all substring ending at ith index digit
 */
public class SumOfAllSubstring {
    public static int sumOfSubstrings(String s) {
        int n = s.length();
        int res = 0;
        int[] sumOfDigits = new int[n];
        sumOfDigits[0] = s.charAt(0) - '0';
        res += sumOfDigits[0];
        for (int i = 1; i < s.length(); i++) {
            sumOfDigits[i] = 10 * sumOfDigits[i - 1] + (i + 1) * (s.charAt(i) - '0');
            res += sumOfDigits[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String num = "1234";
        int sum = sumOfSubstrings(num);
        System.out.println(sum);
    }
}
