// 정수를 나선형으로 배치하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/181832
class Solution {
    public int[][] solution(int n) {
        int[][] map = new int[n][n];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        
        int cx  = 0;    // 현재 위치의 X
        int cy  = 0;    // 현재 위치의 Y
        int dir = 0;    // 현재 위치의 방향
        
        for(int i=1;i<=n*n;i++){
          
            map[cx][cy] = i;
          
            int nx = cx+dx[dir];
            int ny = cy+dy[dir];
            if(!inRange(nx, ny, n) || map[nx][ny]!=0){
                dir = (dir+1)%4;
            }

            cx = cx + dx[dir];
            cy = cy + dy[dir];
        }
        
        return map;
    }
    
    public boolean inRange(int x, int y, int n){
        return x>=0 && y>=0 && x<n && y<n;
    }
}