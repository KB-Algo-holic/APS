// PGM 250136 - 석유시추 
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/250136

import java.util.*;
class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;       // 세로 길이
        int m = land[0].length;    // 가로 길이
 
        int[] oilPerColumn = new int[m];
        boolean[][] visited = new boolean[n][m];
 
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { 
                
                if (land[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    Set<Integer> columns = new HashSet<>();  

                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    int count = 0;  

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int x = curr[0];
                        int y = curr[1];

                        count++;
                        columns.add(y);  

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
 
                    for (int col : columns) {
                        oilPerColumn[col] += count;
                    }
                }
            }
        }
 
        int maxOil = 0;
        for (int oil : oilPerColumn) {
            maxOil = Math.max(maxOil, oil);
        }
        answer = maxOil; 
        return answer;
    }
}
