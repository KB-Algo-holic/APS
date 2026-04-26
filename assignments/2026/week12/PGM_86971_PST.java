// PGM 86971 - 전력망을 둘로 나누기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/86971?language=java

import java.util.LinkedList;
import java.util.Queue;

public class PGM_86971_PST {
    class Solution {
        public int solution(int n, int[][] wires) {
            int[][] map = new int[n + 1][n + 1];
            int min = n;

            for (int[] wire : wires) {
                int towerA = wire[0];
                int towerB = wire[1];
                map[towerA][towerB] = 1;
                map[towerB][towerA] = 1;
            }

            for (int[] wire : wires) {
                int towerA = wire[0];
                int towerB = wire[1];

                map[towerA][towerB] = 0;
                map[towerB][towerA] = 0;

                int count = 0;
                boolean[] visited = new boolean[n + 1];
                Queue<Integer> q = new LinkedList<>();

                q.add(1);
                visited[1] = true;

                while (!q.isEmpty()) {
                    int current = q.poll();
                    count++;

                    for (int next = 1; next <= n; next++) {
                        if (!visited[next] && map[current][next] == 1) {
                            visited[next] = true;
                            q.add(next);
                        }
                    }
                }

                int diff = Math.abs(count - (n - count));
                if (diff < min) {
                    min = diff;
                }

                map[towerA][towerB] = 1;
                map[towerB][towerA] = 1;
            }

            return min;
        }
    }
}
