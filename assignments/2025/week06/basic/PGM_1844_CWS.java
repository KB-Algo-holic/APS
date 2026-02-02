// PGM 1844 - 게임 맵 최단거리
// 유형: DFS/BFS
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/1844

import java.util.*;

class Solution {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static Queue<Integer> queue;
    static int n, m;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        int answer = 0;
        visit = new boolean[n][m];

        queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(0);
        queue.offer(1);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            int cnt = queue.poll();

            if (x == n - 1 && y == m - 1) {
                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maps[nx][ny] == 1 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        queue.offer(nx);
                        queue.offer(ny);
                        queue.offer(cnt+1);

                    }
                }
            }
        }
        return -1;
    }
}