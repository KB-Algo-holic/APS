import java.util.*;

/*
 * 풀이 : 탈출 가능한 모든 길을 탐색하면서 레버를 지날때의 최소 시간 구하기
 * PGM 159993 - 미로 탈출
 * https://school.programmers.co.kr/learn/courses/30/lessons/159993
*/

class Solution {
    static int N;
    static int M;
    static char[][] miro;
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        miro = new char[N][M];
        int sx = 0; int sy = 0; // S : 시작 지점
        int lx = 0; int ly = 0; // L : 레버
        int ex = 0; int ey = 0; // E : 출구

        for (int i = 0; i < N; i++) {
            char[] temp = maps[i].toCharArray();
            for (int j = 0; j < M; j++ ) {
                miro[i][j] = temp[j];
                if (miro[i][j] == 'S') { sx = i; sy = j; }
                if (miro[i][j] == 'L') { lx = i; ly = j; }
                if (miro[i][j] == 'E') { ex = i; ey = j; }
            }
        }
        
        // S -> L 까지의 최단거리 bfs
        int stoL = bfs(sx, sy, lx, ly);
        // L -> E 까지의 최단거리 bfs
        int ltoE = bfs(lx, ly, ex, ey);
        
        if (stoL == -1 || ltoE == -1) answer = -1;
        else answer = stoL + ltoE;
        
        return answer;
    }
    
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int bfs(int startX, int startY, int targetX, int targetY) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int dist = temp[2];
            
            if (x == targetX && y == targetY) return dist;
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (miro[nx][ny] == 'X') continue;
                if (visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dist + 1});
            } 
        }
        return -1;
    }
}
