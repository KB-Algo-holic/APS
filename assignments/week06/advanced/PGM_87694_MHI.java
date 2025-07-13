import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[51][51];

        que.add(new int[] {characterX, characterY, 0});
        visited[characterX][characterY] = true;

        while (!que.isEmpty()) {
            int[] node = que.poll();
            int row = node[0];
            int col = node[1];
            int dist = node[2];

            if (row == itemX && col == itemY)
                return dist;

            for (int i=0; i<4; i++) {
                int nR = row + dr[i];
                int nC = col + dc[i];
                if (1 <= nR && nR <= 50
                        && 1 <= nC && nC <= 50
                        && !isIn(rectangle, row, col, nR, nC)
                        && isOutLine(rectangle, row, col, nR, nC)
                        && !visited[nR][nC]
                ) {
                    visited[nR][nC] = true;
                    que.add(new int[] {nR, nC, dist + 1});
                }
            }
        }

        return 0;
    }
    public boolean isIn(int[][] rectangle, int x, int y, int nX, int nY) {
        float fX = (x + nX) / 2.0f;
        float fY = (y + nY) / 2.0f;
        for (int[] rect : rectangle) {
            if (rect[0] < fX && fX < rect[2] && rect[1] < fY && fY < rect[3]) {
                return true;
            }
        }
        return false;
    }

    public boolean isOutLine(int[][] rectangle, int x, int y, int nX, int nY) {
        for (int[] rect : rectangle) {
            if (isOut(rect, x, y) && isOut(rect, nX, nY)) {
                return true;
            }
        }
        return false;
    }
    public boolean isOut(int[] rect, int x, int y) {
        if ((rect[0] <= x && x <= rect[2] && (y == rect[1] || y == rect[3]))
                || (rect[1] <= y && y <= rect[3] && (x == rect[0] || x == rect[2]))) {
            return true;
        }
        return false;
    }
}