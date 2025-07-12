# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 1844 - 게임 맵 최단거리
# 유형: BFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/1844

import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int n = maps.length, m = maps[0].length;
        boolean[][] visited = new boolean[n--][m--];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1});
        
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            
            if(pos[0] == n && pos[1] == m) {
                answer = pos[2];
                break;
            }
            
            for(int d = 0; d < delta.length; d++) {
                int nr = pos[0] + delta[d][0], nc = pos[1] + delta[d][1];
                
                if(nr >= 0 && nr <= n && nc >= 0 && nc <= m && maps[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc, pos[2] + 1});
                }
            }
        }
        
        return answer;
    }
}