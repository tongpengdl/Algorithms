package gfg.dp;

//Given a string, count number of subsequences of the form aibjck, where i >= 1, j >=1 and k >= 1.
//
//        Note: Two subsequences are considered different if the set of array indexes picked for the 2 subsequences are different.
//
//        Expected Time Complexity : O(n)
//
//        Examples:
//
//        Input  : abbc
//        Output : 3
//        Subsequences are abc, abc and abbc
//
//        Input  : abcabc
//        Output : 7
//        Subsequences are abc, abc, abbc, aabc
//        abcc, abc and abc
//        Asked in : Amazon


/**
 * Created by pengtong on 4/10/17.
 * http://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/
 */

/**
 * Analyze cCount = bCount + cCount + cCount remains true
 * for example, abbcc c,
 * For the last c:
 * (1)Current c combines with bCount sequence --> bCount
 * (2)Current c combines with previous c sequence --> cCount
 * (3)Do not use current, so cCount remains as previous --> cCount
 * Those 3 situations covers all cases
 */
public class NumberOfSequence {
    public static int countSubsequences(String s) {
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'a') {
                aCount = 1 + 2 * aCount;
            }

            if (ch == 'b') {
                bCount = aCount + 2 * bCount;
            }

            if (ch == 'c') {
                cCount = bCount + 2 * cCount;
            }
        }

        return cCount;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        int num = countSubsequences(s);
        System.out.println(num);
    }
}
