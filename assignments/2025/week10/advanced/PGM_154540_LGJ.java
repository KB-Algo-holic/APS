// PGM - 무인도 여행
// 큐
// https://school.programmers.co.kr/learn/courses/30/lessons/154540

import java.util.*;

class Solution {
    //무인도 값의 합
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    List<Integer> foodCounts = new ArrayList<Integer>();

    public int[] solution(String[] maps) {

        int r_cnt = maps.length;
        int c_cnt = maps[0].length();
        int[][] visited = new int[r_cnt][c_cnt];
        int maxFood = 0;
        for (int i = 0; i < r_cnt; i++) {
            for (int j = 0; j < c_cnt; j++) {
                if (maps[i].charAt(j) != 'X' && visited[i][j] == 0) {
                    bfs(i, j, maps, visited, r_cnt, c_cnt);
                }
            }
        }

        foodCounts.sort(Comparator.naturalOrder());
        int[] answer = !foodCounts.isEmpty() ? new int[foodCounts.size()] : new int[] {-1};

        for (int i = 0; i < foodCounts.size(); i++) {
            answer[i]  = foodCounts.get(i);
        }
        return answer;
    }

    public void bfs(int r, int c, String[] maps, int[][] visited, int r_cnt, int c_cnt) {
        Deque<int[]> deque = new ArrayDeque<int[]>();
        int total_food = Character.getNumericValue(maps[r].charAt(c));
        visited[r][c] = 1;
        deque.offer(new int[] {r, c});


        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int cur_r = cur[0];
            int cur_c = cur[1];

            for (int i=0; i<4; i++) {
                int new_r = cur_r + dr[i];
                int new_c = cur_c + dc[i];
                if (new_r < 0 || new_r >= r_cnt || new_c < 0 || new_c >= c_cnt) {continue;}
                if ('X' == (maps[new_r].charAt(new_c))) { continue; }
                if (visited[new_r][new_c] == 1) { continue; }
                // 방문처리
                visited[new_r][new_c] = 1;
                total_food += Character.getNumericValue(maps[new_r].charAt(new_c));
                deque.offer(new int[] {new_r, new_c});

            }
        }

        // 방문 결과
        foodCounts.add(total_food);
    }
}
