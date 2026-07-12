// PGM 67259 - 경주로 건설
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/67259?language=java

import java.util.*;

public class PGM_67259_PST {
    class Solution {
        private static final int[] dx = {-1, 1, 0, 0};
        private static final int[] dy = {0, 0, -1, 1};

        static class Node {
            int x, y, cost, dir;

            Node(int x, int y, int cost, int dir) {
                this.x = x;
                this.y = y;
                this.cost = cost;
                this.dir = dir;
            }
        }

        public int solution(int[][] board) {
            int n = board.length;

            int[][][] cost = new int[n][n][4];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(cost[i][j], Integer.MAX_VALUE);
                }
            }

            Queue<Node> queue = new LinkedList<>();

            if (board[1][0] == 0) {
                queue.add(new Node(1, 0, 100, 1));
                cost[1][0][1] = 100;
            }
            if (board[0][1] == 0) {
                queue.add(new Node(0, 1, 100, 3));
                cost[0][1][3] = 100;
            }

            int answer = Integer.MAX_VALUE;

            while (!queue.isEmpty()) {
                Node curr = queue.poll();

                if (curr.x == n - 1 && curr.y == n - 1) {
                    answer = Math.min(answer, curr.cost);
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = curr.x + dx[i];
                    int ny = curr.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) {
                        continue;
                    }

                    int nextCost = curr.cost + (curr.dir == i ? 100 : 600);

                    if (nextCost < cost[nx][ny][i]) {
                        cost[nx][ny][i] = nextCost;
                        queue.add(new Node(nx, ny, nextCost, i));
                    }
                }
            }
            return answer;
        }
    }
}

