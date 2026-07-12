// PGM 67259 경주로 건설
// BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/67259?language=java
// 각 지점에 인입된 방향도 고려해야함 (costs 배열을 3차원으로 변경)

import java.util.*;

class Solution {
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};

    public int solution(int[][] board) {
        int n = board.length;

        // 3차원 비용 배열: [행][열][진입 방향]
        // 방향 지표 - 0: 하, 1: 우, 2: 상, 3: 좌
        int[][][] costs = new int[n][n][4];

        // 비용 배열을 최대치로 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<int[]> q = new ArrayDeque<>();

        // 시작점 설정 (첫 출발 시 4개 방향에 대해 모두 0으로 초기화 가능하도록 세팅)
        // 처음에 어느 방향으로든 갈 수 있도록 dir을 -1로 시작
        q.offer(new int[] {0, 0, 0, -1});

        int minCost = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], cost = cur[2], dir = cur[3];

            // 목적지 도달 시 최소 비용 갱신
            if (r == n - 1 && c == n - 1) {
                minCost = Math.min(minCost, cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 범위를 벗어나거나 벽인 경우 스킵
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || board[nr][nc] == 1) continue;

                // 비용 계산
                int ncost = 100;
                if (dir != -1 && dir != i) { // 첫 이동이 아니고, 방향이 전환된 경우
                    ncost += 500;
                }

                int nextTotalCost = cost + ncost;

                // 핵심 수정 포인트: 해당 방향(i)으로의 기존 비용과 비교
                // 기존 저장된 비용보다 '작을 때만' 갱신하고 큐에 삽입
                if (costs[nr][nc][i] > nextTotalCost) {
                    costs[nr][nc][i] = nextTotalCost;
                    q.offer(new int[] {nr, nc, nextTotalCost, i});
                }
            }
        }

        return minCost;
    }
}