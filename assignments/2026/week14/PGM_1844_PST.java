// PGM 1844 - 게임 맵 최단거리
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/1844

import java.util.LinkedList;
import java.util.Queue;

public class PGM_1844_PST {
    class Solution {
        public int solution(int[][] maps) {
            int n = maps.length;
            int m = maps[0].length;

            int[] disX = {-1, 1, 0, 0};
            int[] disY = {0, 0, -1, 1};

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + disX[i];
                    int ny = y + disY[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
                        if (nx == 0 && ny == 0) {
                            continue;
                        }
                        maps[nx][ny] = maps[x][y] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            int answer = maps[n - 1][m - 1];

            return answer > 1 ? answer : -1;
        }
    }
}
