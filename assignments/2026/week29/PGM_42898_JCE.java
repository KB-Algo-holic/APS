/*
 * 요구사항 : 집(1,1)에서 학교(m,n)까지 물에 잠긴 지역을 피해 오른쪽과 아래쪽으로만 움직여 갈 수 있는 최단 경로의 개수를
 *           1,000,000,007로 나눈 나머지를 구해라
 * dp (각 지역으로의 경로의 수 점화식 구하기)
 * 점화식 : dp[i][j] = dp[i-1][j] + dp[i][j-1]
 */



public static int solution(int m, int n, int[][] puddles) {
    int answer = 0;
    int[][] map = new int[n + 1][m + 1];
    boolean[][] isPuddle = new boolean[n + 1][m + 1];
    for (int i = 0; i < puddles.length; i++) {
        isPuddle[puddles[i][1]][puddles[i][0]] = true;
    }

    // 처음 오른쪽 길 초기화
    for (int i = 1; i <= m; i++) {
        if (isPuddle[1][i]) break;
        map[1][i] = 1;
    }

    // 처음 아래쪽 길 초기화
    for (int i = 1; i <= n; i++) {
        if (isPuddle[i][1]) break;
        map[i][1] = 1;
    }

    for (int i = 2; i <= n; i++) {
        for (int j = 2; j <= m; j++) {
            if (isPuddle[i][j]) continue;
            map[i][j] = map[i-1][j] + map[i][j-1];
            map[i][j] %= 1000000007;
        }
    }

    answer = map[n][m];
    return answer;
}
