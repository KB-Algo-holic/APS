import java.util.LinkedList;
import java.util.Queue;

// PGM - 1844 L2_게임맵최단거리
// DFS/BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/1844
public class PGM_1844_YHS {
    int dr[] = {0,0,-1,1};
    int dc[] = {-1,1,0,0};

    boolean isIn(int r, int c, int R, int C){
        return (r>=0 && c>=0 && r<R && c<C);
    }

    boolean[][] isVisited;
    int R,C;

    public int solution(int[][] maps) {
        int answer = 0;

        R = maps.length;
        C = maps[0].length;

        isVisited = new boolean[R][C];

        answer = bfs(maps);

        return answer;
    }

    int bfs(int[][] map){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        isVisited[0][0] = true;
        int sum = -1;

        while(!queue.isEmpty()){
            int[] front = queue.poll();

            if(front[0] == R-1 && front[1] == C-1){
                sum = front[2];
                break;
            }

            for(int d=0; d<4; d++){
                int nr = front[0] + dr[d];
                int nc = front[1] + dc[d];

                if(isIn(nr, nc, R, C) && !isVisited[nr][nc] && map[nr][nc] != 0){
                    queue.offer(new int[]{nr,nc,front[2]+1});
                    isVisited[nr][nc] = true;
                }
            }
        }


        return sum;
    }
}
