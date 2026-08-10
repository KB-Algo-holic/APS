// 01 Matrix
// https://leetcode.com/problems/01-matrix/
// BFS

import java.util.*;

class Move {
    int r, c;
    int times;

    Move(int r, int c, int times) {
        this.r = r;
        this.c = c;
        this.times = times;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[][] answer = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(answer[i], -1);
        }

        Deque<Move> bfsQueue = new ArrayDeque<>();
        int[][] dir = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
        };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    answer[i][j] = 0;
                    bfsQueue.addLast(new Move(i, j, 0));
                }
            }
        }

        while (!bfsQueue.isEmpty()) {
            Move first = bfsQueue.pollFirst();

            for (int d = 0; d < 4; d++) {
                int newR = first.r + dir[d][0];
                int newC = first.c + dir[d][1];

                if (0 <= newR && newR < rows
                        && 0 <= newC && newC < cols
                        && answer[newR][newC] == -1) {

                    answer[newR][newC] = first.times + 1;

                    bfsQueue.addLast(new Move(newR, newC, first.times + 1));
                }
            }
        }

        return answer;
    }
}
