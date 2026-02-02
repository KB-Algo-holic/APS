// PGM 석유시추
// DFS && BFS
//https://school.programmers.co.kr/learn/courses/30/lessons/250136

import java.util.*;

class Solution {
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};

    public int solution(int[][] land) {
        int answer = 0;
        int r_cnt = land.length;
        int c_cnt = land[0].length;
        int[][] visited = new int[r_cnt][c_cnt];
        HashMap<Integer, Integer> map = new HashMap<>();
        int oil_idx = 0;

        for (int c=0; c<c_cnt; c++) {
            for (int r=0; r<r_cnt; r++) {
                if (land[r][c] == 1 && visited[r][c] == 0) {
                    oil_idx ++;
                    visited[r][c] = oil_idx;
                    map.put(oil_idx, bfs(r, c, land, visited, oil_idx));
                }
            }
        }

        for (int c=0; c<c_cnt; c++) {
            boolean[] checked = new boolean[oil_idx+1];
            int total = 0;
            for (int r=0; r<r_cnt; r++) {
                int cur_oil_idx = visited[r][c];
                if (cur_oil_idx != 0 && !checked[cur_oil_idx]) {
                    total += map.get(cur_oil_idx);
                    checked[cur_oil_idx] = true;
                }
            }
            if (total > answer) answer = total;
        }

        return answer;
    }

    public int bfs(int sr, int sc, int[][] land, int[][] visited, int oil_idx) {
        int total = 0;
        int r_cnt = land.length;
        int c_cnt = land[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        total ++;
        q.offer(new int[] {sr, sc});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_r = cur[0];
            int cur_c = cur[1];

            for (int i=0; i<4; i++) {
                int new_r = cur_r + dr[i];
                int new_c = cur_c + dc[i];

                if (new_r < 0 || new_r >= r_cnt || new_c < 0 || new_c >= c_cnt) continue;
                if (visited[new_r][new_c] != 0) continue;
                if (land[new_r][new_c] != 1) continue;
                visited[new_r][new_c] = oil_idx;
                total++;
                q.offer(new int[] {new_r, new_c});
            }
        }

        return total;
    }
}