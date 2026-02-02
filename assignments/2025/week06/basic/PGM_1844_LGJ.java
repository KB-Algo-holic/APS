// PGM 게임 맵 최단거리
// BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/1844

import java.util.*;

class Solution {
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};

    public int solution(int[][] maps) {
        // basic var init
        int rowCnt = maps.length;
        int colCnt = maps[0].length;
        boolean[][] visited = new boolean[rowCnt][colCnt];
        int[][] result = new int[rowCnt][colCnt];
        Queue<int[]> q = new ArrayDeque<>();
        int[] start = {0, 0, 1};
        visited[start[0]][start[1]] = true;
        result[start[0]][start[1]] = 1;
        q.offer(start);

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int cnt = curr[2];
            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow < 0 || newRow >= rowCnt || newCol < 0 || newCol >= colCnt) { continue; }
                if (visited[newRow][newCol] || maps[newRow][newCol] == 0) { continue; }

                visited[newRow][newCol] = true;
                result[newRow][newCol] = cnt+1;
                q.offer(new int[]{newRow, newCol, cnt+1});

            }
        }
        return result[rowCnt-1][colCnt-1] == 0 ? -1 : result[rowCnt-1][colCnt-1];
    }
}