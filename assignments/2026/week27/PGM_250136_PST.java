// PGM 250136 - 석유 시추
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/250136?language=java

import java.util.*;

public class PGM_250136_PST {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        boolean[][] visited = new boolean[n][m];

        int[] totalOilPerCol = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {

                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    int oilSize = 0;

                    Set<Integer> cols = new HashSet<>();

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int x = current[0];
                        int y = current[1];

                        oilSize++;
                        cols.add(y);

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                                if (land[nx][ny] == 1 && !visited[nx][ny]) {
                                    visited[nx][ny] = true;
                                    queue.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    for (int col : cols) {
                        totalOilPerCol[col] += oilSize;
                    }
                }
            }
        }
        int maxOil = 0;
        for (int oil : totalOilPerCol) {
            maxOil = Math.max(maxOil, oil);
        }
        return maxOil;
    }
}
