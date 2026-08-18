// PGM - 42898 등굣길
// DP
// https://school.programmers.co.kr/learn/courses/30/lessons/42898
public class PGM_42898_YHS {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int mod = 1000000007;
        int[][] dp = new int[n][m];

        for(int i=0; i< puddles.length; i++){
            int r = puddles[i][1]-1;
            int c = puddles[i][0]-1;

            dp[r][c] = -1;

        }

        boolean flag = false;

        for(int r=0; r<n; r++){

            if(dp[r][0] == -1){
                flag = true;
            }else{
                if(!flag){
                    dp[r][0] = 1;
                }else{
                    dp[r][0] = -1;
                }
            }
        }
        flag = false;
        for(int c=0; c<m; c++){
            if(dp[0][c] == -1){
                flag = true;
            }else{
                if(!flag){
                    dp[0][c] = 1;
                }else{
                    dp[0][c] = -1;
                }
            }
        }

        for(int r=1; r<n; r++){
            for(int c=1; c<m; c++){
                if(dp[r][c] == -1) continue;

                dp[r][c] = ((dp[r-1][c] == -1 ? 0 : dp[r-1][c]) + (dp[r][c-1] == -1 ? 0 : dp[r][c-1])) % mod;
            }
        }

        // for(int[] x : dp){
        //     System.out.println(Arrays.toString(x));
        // }
        answer = dp[n-1][m-1];

        return answer;
    }
}
