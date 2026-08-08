import java.util.*;
class Solution {
    public int solution(int[][] land) {
        int answer = 0;

    int n = land.length;      // 세로
    int m = land[0].length;   // 가로
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    boolean[][] visited = new boolean[n][m];
    int[][] label = new int[n][m];
    int[] chunk = new int[n * m];
    int labelCnt = 1;

    // 1단계: 라벨링 (BFS로 덩어리마다 번호 매기고 크기 저장)
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (land[i][j] == 0) continue;
            if (visited[i][j]) continue;

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] {i, j, 1});
            visited[i][j] = true;
            label[i][j] = labelCnt;
            int size = 1;

            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                int r = temp[0];
                int c = temp[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dx[d];
                    int nc = c + dy[d];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                    if (visited[nr][nc]) continue;
                    if (label[nr][nc] != 0) continue;
                    if (land[nr][nc] == 0) continue;

                    queue.offer(new int[] {nr, nc, size + 1});
                    visited[nr][nc] = true;
                    label[nr][nc] = labelCnt;
                    size++;
                }
            }
            chunk[labelCnt] = size;
            labelCnt++;
        }
    }

    // 2단계: 시추관(열)마다 겹치는 덩어리들의 크기 합산, 최댓값 갱신
    for (int i = 0; i < m; i++) {           // i = 열(시추관)
        boolean[] chunkCheck = new boolean[labelCnt];
        int sum = 0;
        for (int j = 0; j < n; j++) {       // j = 그 열의 행
            if (label[j][i] != 0 && !chunkCheck[label[j][i]]) {
                chunkCheck[label[j][i]] = true;
                sum += chunk[label[j][i]];
            }
        }
        answer = Math.max(answer, sum);
    }

    return answer;
    }
}
