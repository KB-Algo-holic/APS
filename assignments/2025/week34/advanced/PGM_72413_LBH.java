// PGM 72413 - 합승 택시 요금
// 플로이드 워셜
// https://school.programmers.co.kr/learn/courses/30/lessons/72413

import java.util.*;

class Solution {
    int INF = 99999999;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        int[][] dist = new int[n + 1][n + 1];
        Arrays.setAll(dist, i -> {
            int[] row = new int[n + 1];
            Arrays.fill(row, INF);
            return row;
        });

        for(int i = 1; i <= n; i++) {
            dist[i][i] = 0;
        }
        for(int i = 0; i < fares.length; i++) {
            dist[fares[i][0]][fares[i][1]] = fares[i][2];
            dist[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(dist[j][i] == INF || dist[i][k] == INF) {continue;}
                    if(dist[j][k] > dist[j][i] + dist[i][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(answer > dist[s][i] + dist[i][a] + dist[i][b]) {
                answer = dist[s][i] + dist[i][a] + dist[i][b];
            }
        }

        return answer;
    }
}