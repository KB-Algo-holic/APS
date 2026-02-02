import java.util.*;
class Solution {

    static int[][] dp, map;
    static int[] dr = {1,0}, dc = {0, 1};
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dp[i], -1);

        map = new int[m][n];
        for(int i=0; i<puddles.length; i++){
            map[puddles[i][0] - 1][puddles[i][1] - 1] = 1;
        }

        return makeAnswer(0,0, m, n);
    }
    public int makeAnswer(int m, int n, int M, int N) {

        if(m == M-1 && n == N-1) return 1;

        if(dp[m][n] != -1) return dp[m][n];

        int result = 0;
        for(int i=0; i<2; i++) {
            int nextR = m+dr[i];
            int nextC = n+dc[i];
            if(nextR < M && nextC < N && map[nextR][nextC] == 0){
                result += makeAnswer(nextR, nextC, M, N);
                result %= 1000000007;
            }
        }

        return dp[m][n] = result;
    }
}