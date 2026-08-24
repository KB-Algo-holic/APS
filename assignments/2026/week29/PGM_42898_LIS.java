// PGM 42898 - 등굣길
// 학습 
// https://school.programmers.co.kr/learn/courses/30/lessons/42898?language=java
class Solution {
    static int row, col;
    static int[][] DP;
    static int er, ec;
    static int mod = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        row = n;
        col = m;
        DP = new int[row][col];

        DP[0][0] = 1;
        er = row-1;
        ec = col-1;

        for (int[] pu : puddles) {
            int r = pu[1]-1;
            int c = pu[0]-1;
            DP[r][c] = -1;
        }

        for (int c = 1; c < col; c++) {
            if (DP[0][c] == -1) continue;
            DP[0][c] = DP[0][c-1];
        }

        for (int r = 1; r < row; r++) {
            if (DP[r][0] == -1) continue;
            DP[r][0] = DP[r-1][0];
        }

        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                
                if (DP[r][c] == -1) continue;
                else if (DP[r][c] != -1) {
                    int up = DP[r-1][c];
                    int left = DP[r][c-1];
                    if (DP[r-1][c] == -1) up = 0;
                    if (DP[r][c-1] == -1) left = 0;

                    DP[r][c] = (up + left) % mod;
                }
            }
        }


        return DP[er][ec];
    }
}
