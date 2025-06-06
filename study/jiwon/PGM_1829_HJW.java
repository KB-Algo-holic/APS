// BOJ 1829 - 카카오프렌즈 컬러링북
// 유형: BFS
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/1829

import java.util.*;

class Solution {
    int[] dx = new int[] {1, -1, 0, 0};
    int[] dy = new int[] {0, 0, 1, -1};
    int[][] visited;
    int area = 0;
    int max = 0;
    
    public void bfs(int x, int y, int m, int n, int[][] picture) {
        this.area += 1;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[x][y] = 1;
        queue.add(new int[] {x, y});
        int cnt = 0;
        int target = picture[x][y];
        
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int a = node[0];
            int b = node[1];
            cnt ++;
            
            for (int i=0; i<4; i++) {
                x = a + this.dx[i];
                y = b + this.dy[i];
                
                if (0 <= x && x < m && 0 <= y && y < n && visited[x][y] == 0 && picture[x][y] == target) {
                    visited[x][y] = 1;
                    queue.add(new int[] {x, y});
                }
            }
        }
        
        if (cnt > this.max) this.max = cnt;
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        
        this.visited = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (this.visited[i][j] == 0 && picture[i][j] != 0) {
                    bfs(i, j, m, n, picture);
                }
            }
        }
        
        return new int[] {this.area, this.max};
    }
}
