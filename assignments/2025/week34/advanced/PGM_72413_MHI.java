import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int INF = 20000001;
        int[][] d = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], INF);
            d[i][i] = 0;
        }

        for (int[] fare : fares) {
            int u = fare[0] - 1;
            int v = fare[1] - 1;
            int cost = fare[2];
            d[u][v] = cost;
            d[v][u] = cost;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (d[j][k] > d[j][i] + d[i][k]) {
                        d[j][k] = d[j][i] + d[i][k];
                    }
                }
            }
        }

        long minv = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long currentFare = (long) d[s-1][i] + d[i][a-1] + d[i][b-1];
            if (minv > currentFare) {
                minv = currentFare;
            }
        }

        return (int) minv;
    }
}