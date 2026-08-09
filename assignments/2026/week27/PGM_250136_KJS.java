// PGM 250136 - 석유시추
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/250136?language=java

import java.util.*;

class Solution {
    
    // 가로, 세로 길이
    static int n, m;
    // 시추관 위치별 석유량 
    static int[] oil;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
        m = land[0].length;
        oil = new int[m];
        
        boolean[][] visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1 && visited[i][j] == false){
                    bfs(land, visited, i, j);
                }
            }
        }
        
        answer = Arrays.stream(oil).max().getAsInt();
        return answer;
    }
    
    public void bfs(int[][] land, boolean[][] visited, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        
        // 상, 하, 좌, 우 이동
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int count = 1;
        Set<Integer> set = new HashSet<>();
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            set.add(now[1]);
            
            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                // 땅 범위를 넘는 경우 생략
                if (!checkRange(nx, ny)) {
                    continue;
                }

                // 빈 땅이거나, 방문한 적이 있는 경우
                if (land[nx][ny] == 1 && visited[nx][ny] == false) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count += 1;
                }
            }
        }
        
        for (int index : set) {
            oil[index] += count;
        }
        
    }
    
    public boolean checkRange(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        return true;
    }
}
