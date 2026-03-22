import java.util.*;
import java.io.*;

class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int number = 1;
        int curX = 0;
        int curY = 0;
        int dir = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
 
        while(n*n >= number) {    // n*n까지 채웠으면 종료
            
            answer[curX][curY] = number++;
            
            int nx = dx[dir] + curX;
            int ny = dy[dir] + curY; 
            // 범위 넘거나 0 아닌 다른 숫자 있으면 방향 전환
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || answer[nx][ny] != 0) {
                // d 방향대로 증가
                dir = (dir + 1) % 4;
                nx = dx[dir] + curX;
                ny = dy[dir] + curY;
            }
            
            curX = nx;
            curY = ny;
        }
        
        return answer;
    }
}
