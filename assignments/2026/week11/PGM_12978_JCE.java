class Solution {
    public static int solution(int N, int[][] road, int K) {
    int answer = 0;
    int[][] town = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {

            if (i == j) {
                town[i][j] = 0;
                continue;
            }
            town[i][j] = 500001;
        }
    }

    for (int[] r : road) {
        int a = r[0];
        int b = r[1];
        if (town[a][b] > r[2])  // 값이 이미 있으면 더 작은 값 저장
            town[a][b] = town[b][a] = r[2];
    }

    for (int k = 1; k <= N; k++) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                town[i][j] = Math.min(town[i][j], town[i][k] + town[k][j]);
            }
        }
    }

    for (int i = 1; i <= N; i++) {
        if (town[1][i] <= K) answer++;
    }

    return answer;
}
}
