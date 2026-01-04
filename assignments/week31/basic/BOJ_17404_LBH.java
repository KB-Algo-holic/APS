// BOJ 17404 - RGB거리 2
// 동적계획법
// https://www.acmicpc.net/problem/17404

import java.util.*;

public class Main {

    public static int solution(int N, int[][] rgbCosts) {
        int answer = Integer.MAX_VALUE;
        int[][] dp = new int[N][3];

        for(int i = 0; i < 3; i++) {
            dp[0][i] = rgbCosts[0][i];;
            dp[0][(i + 1) % 3] = 99999999;
            dp[0][(i + 2) % 3] = 99999999;

            for(int j = 1; j < N; j++) {
                dp[j][0] =  Math.min(dp[j-1][1], dp[j-1][2]) + rgbCosts[j][0];
                dp[j][1] =  Math.min(dp[j-1][0], dp[j-1][2]) + rgbCosts[j][1];
                dp[j][2] =  Math.min(dp[j-1][0], dp[j-1][1]) + rgbCosts[j][2];

                if(j == N - 1) {
                    dp[N - 1][i] = Integer.MAX_VALUE;
                }
            }

            for(int j = 0; j < 3; j++) {
                if(answer > dp[N - 1][j]) {
                    answer = dp[N - 1][j];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] rgbCosts = new int[N][3];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                rgbCosts[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(N, rgbCosts));

        sc.close();
    }
}