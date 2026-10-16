// PGM 159993 미로탈출
// BFS 2번돌리기..
// https://school.programmers.co.kr/learn/courses/30/lessons/159993
 
import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int xsize = maps.length;
        int ysize= maps[0].length();
        Queue<int[]> que = new LinkedList<>();
        boolean[][][] visited = new boolean[xsize][ysize][2];
        
        int[] start = new int[2];
        int[] goal = new int[2];
        int[] lever = new int[2];
        
        for(int i = 0;i < xsize; i++){
            for(int j = 0; j < ysize; j++){
                if(maps[i].charAt(j) =='S')
                {
                    start[0] = i;
                    start[1] = j;
                }
                if(maps[i].charAt(j) == 'L'){
                    lever[0] = i;
                    lever[1] = j;
                }
                if(maps[i].charAt(j) == 'E'){
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }
        // x , y , 깃발접촉여부, 이동시간
        que.offer(new int[] {start[0], start[1], 0, 0});
        visited[start[0]][start[1]][0] = true;
        while(!que.isEmpty()){
            int[] now = que.poll();
            int nowx = now[0];
            int nowy = now[1];
            int flag = now[2];
            int ntime = now[3];
            
            if(flag == 1 && nowx == goal[0] && goal[1] == nowy){
                return ntime;
            }
            
            for(int i =0;i < 4; i++){
                int nx = nowx + dx[i];
                int ny = nowy + dy[i];
                
                if(nx >= 0 && nx <xsize && ny >=0 && ny<ysize){
                    if(maps[nx].charAt(ny) != 'X'){
                        if(!visited[nx][ny][flag]){
                            int nextflg = flag;
                            if(nx == lever[0] && ny == lever[1])
                                nextflg = 1;
                            que.offer(new int[] {nx, ny, nextflg, ntime + 1});{
                                visited[nx][ny][nextflg] = true;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
