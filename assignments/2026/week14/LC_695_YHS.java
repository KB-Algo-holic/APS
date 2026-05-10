// LC - 695 Max Area of Island
// bfs
// https://leetcode.com/problems/max-area-of-island/description/
import java.util.LinkedList;
import java.util.Queue;

public class LC_695_YHS {
    int R,C,max;
    boolean[][] isVisited;

    int[] dr = {0,0,-1,1};
    int[] dc = {-1,1,0,0};

    boolean isIn(int r, int c, int R, int C){
        return (r>=0 && r<R && c>=0 && c<C);
    }

    public int maxAreaOfIsland(int[][] grid) {
        R = grid.length;
        C = grid[0].length;
        isVisited = new boolean[R][C];

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(!isVisited[r][c] && grid[r][c] == 1){
                    bfs(r, c, grid);
                }
            }
        }

        return max;
    }

    void bfs(int r, int c, int[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        isVisited[r][c] = true;
        int sum = 0;

        while(!queue.isEmpty()){
            sum++;
            if(max < sum){
                max = sum;
            }
            int[] front = queue.poll();

            for(int d=0; d<4; d++){
                int nr = front[0] + dr[d];
                int nc = front[1] + dc[d];

                if(isIn(nr,nc,R,C) && !isVisited[nr][nc] && grid[nr][nc] == 1){
                    isVisited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
