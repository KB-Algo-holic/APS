// PGM - 159993 L2_미로탈출
// BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/159993
import java.util.LinkedList;
import java.util.Queue;

public class PGM_159993_YHS {
    int R,C;
    boolean[][] isVisited;
    char[][] map;

    int[] dr = {0,0,-1,1};
    int[] dc = {-1,1,0,0};

    boolean isIn(int r, int c, int R, int C){
        return (r>=0 && r<R && c>=0 && c<C);
    }

    public int solution(String[] maps) {
        int answer = 0;

        R = maps.length;
        C = maps[0].length();

        map = new char[R][C];
        isVisited = new boolean[R][C];

        int sr=0,sc=0,lr=0,lc=0,er=0,ec=0;

        for(int r=0; r<R; r++){
            String line = maps[r];
            for(int c=0; c<C; c++){
                char ch = line.charAt(c);
                map[r][c] = ch;

                if(ch == 'S'){
                    sr = r;
                    sc = c;
                }

                if(ch == 'L'){
                    lr = r;
                    lc = c;
                }

                if(ch == 'E'){
                    er = r;
                    ec = c;

                }
            }
        }

        int toLever = bfs(sr, sc, lr, lc);
        if(toLever == 0) return -1;

        isVisited = new boolean[R][C];
        int toEnd = bfs(lr, lc, er, ec);
        if(toEnd == 0) return -1;

        answer = toLever + toEnd;

        return answer;
    }

    int bfs(int sr, int sc, int er, int ec){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc, 0});
        isVisited[sr][sc] = true;
        int time = 0;

        while(!queue.isEmpty()){
            int[] front = queue.poll();
            // System.out.println(front[0]+"  "+front[1]);
            if(front[0] == er && front[1] == ec){
                time = front[2];
                break;
            }

            for(int d=0; d<4; d++){
                int nr = front[0] + dr[d];
                int nc = front[1] + dc[d];

                if(isIn(nr, nc, R, C) && !isVisited[nr][nc] && map[nr][nc] != 'X'){
                    isVisited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, front[2]+1});
                }
            }
        }

        return time;
    }
}
