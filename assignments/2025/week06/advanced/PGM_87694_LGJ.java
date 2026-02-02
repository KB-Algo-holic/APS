// PGM - 아이템줍기
// BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/87694?language=java

import java.util.*;

class Solution {
    static final int MAX = 102; // 좌표가 50까지 → 2배 스케일링
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] board = new int[MAX][MAX];
    static boolean[][] visited = new boolean[MAX][MAX];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        // 테두리 칠하기
        for (int[] rect: rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int x = x1; x <= x2; x++) {
                board[x][y1] = 1; // 아래쪽 테두리
                board[x][y2] = 1; // 위쪽 테두리
            }
            for (int y = y1; y <= y2; y++) {
                board[x1][y] = 1; // 왼쪽 테두리
                board[x2][y] = 1; // 오른쪽 테두리
            }
        }

        // 겹치는 테두리 삭제 (위 포문에서 진행 시 각 단계 별로 삭제 왜곡 발생)
        for (int[] rect: rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    board[x][y] = 0;
                }
            }
        }

        // BFS 탐색
        Queue<int[]> q = new ArrayDeque<>();
        int sx = characterX * 2; // 캐릭터 (시작x)
        int sy = characterY * 2; // 캐릭터 (시작y)
        int ex = itemX * 2; // 아이템 (목표 x)
        int ey = itemY * 2; // 아이템 (목표 y)

        q.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], dist = cur[2];

            if (r == ex && c == ey) return dist / 2; // 스케일 되돌림

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= MAX || nc >= MAX) continue;
                if (!visited[nr][nc] && board[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1; // 도달 불가능
    }

}