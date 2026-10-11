// BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/1844

import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length; 
        int m = maps[0].length;
        // 큐에 현재 위치와 지나온 칸 수를 넣고 방문체크
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        // 사방으로 이동하면서 이동할 수 있으면 큐에 넣고 방문체크
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            // 도착을 했을 때 이동한 칸 수 리턴, 도착 못했으면 -1
            if (cur[0] == n - 1 && cur[1] == m - 1) return cur[2];
            
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (maps[nx][ny] == 0) continue;
                
                queue.offer(new int[]{nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
                
            }
        }
           
        return -1;
    }
}
