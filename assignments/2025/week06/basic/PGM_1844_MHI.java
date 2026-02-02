import java.util.*;
class Solution {
    public int solution(int[][] maps) {

        int R = maps.length - 1;
        int C = maps[0].length - 1;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[R + 1][C + 1];

        que.add(new int[] {0, 0, 1});
        visited[0][0] = true;

        while (!que.isEmpty()) {
            int[] node = que.poll();
            int row = node[0];
            int col = node[1];
            int dist = node[2];

            if (row == R && col == C)
                return dist;

            for (int i=0; i<4; i++) {
                int nR = row + dr[i];
                int nC = col + dc[i];
                if (0 <= nR && nR <= R
                        && 0 <= nC && nC <= C
                        && maps[nR][nC] == 1
                        && !visited[nR][nC]
                ) {
                    visited[nR][nC] = true;
                    que.add(new int[] {nR, nC, dist + 1});
                }
            }
        }
        return -1;
    }
}