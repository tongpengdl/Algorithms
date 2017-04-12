package gfg.dp;

//http://www.geeksforgeeks.org/gold-mine-problem/
//        Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons. Initially the miner is at first column but can be at any row. He can move only (right->,right up /,right down\) that is from a given cell, the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right. Find out maximum amount of gold he can collect.
//
//        Examples:
//
//        Input : mat[][] = {{1, 3, 3},
//        {2, 1, 4},
//        {0, 6, 4}};
//        Output : 12
//        {(1,0)->(2,1)->(2,2)}
//
//        Input: mat[][] = { {1, 3, 1, 5},
//        {2, 2, 4, 1},
//        {5, 0, 2, 3},
//        {0, 6, 1, 2}};
//        Output : 16
//        (2,0) -> (1,1) -> (1,2) -> (0,3) OR
//        (2,0) -> (3,1) -> (2,2) -> (2,3)
//
//        Input : mat[][] = {{10, 33, 13, 15},
//        {22, 21, 04, 1},
//        {5, 0, 2, 3},
//        {0, 6, 14, 2}};
//        Output : 83

public class GoldMine {
    public static int getMaxGold(int[][] gold, int m, int n) {
        int[][] goldTable = new int[m][n];
        for (int col = n - 1; col >= 0; col--) {
            for (int row = 0; row < m; row++) {
                int right = col == n - 1 ? 0 : goldTable[row][col + 1];
                int rightUp = (col == n - 1 || row == 0) ? 0 : goldTable[row - 1][col + 1];
                int rightDown = (col == n - 1 || row == m - 1) ? 0 : goldTable[row + 1][col + 1];

                goldTable[row][col] = Math.max(right, Math.max(rightUp, rightDown)) + gold[row][col];
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            res = Math.max(res, goldTable[i][0]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] gold = { {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}
        };

        int m = 4;
        int n = 4;

        int max = getMaxGold(gold, m, n);
        System.out.println(max);
    }
}
