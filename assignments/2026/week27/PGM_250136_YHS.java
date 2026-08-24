// PGM - 250136 L2_석유시추
// BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/250136
import java.util.*;

public class PGM_250136_YHS {
    int R, C, mem[][];
    boolean isVisited[][];
    Map<Integer, Integer> map = new HashMap<>();
    public int solution(int[][] land) {
        int answer = 0;

        R = land.length;
        C = land[0].length;
        mem = new int[R][C];
        isVisited = new boolean[R][C];

        int cnt = 1;

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(land[r][c] == 1 && !isVisited[r][c]){
                    bfs(r, c, land, cnt++);
                }
            }
        }

        // for(int[] x: mem){
        //     System.out.println(Arrays.toString(x));
        // }
        // System.out.println(map);

        for(int c=0; c<C; c++){
            Set<Integer> set = new HashSet<>();
            int sum = 0;
            for(int r=0; r<R; r++){
                int no = mem[r][c];
                if(no != 0 && !set.contains(no)){
                    set.add(no);
                    sum += map.get(no);
                }
            }
            if(answer < sum){
                answer = sum;
            }
        }


        return answer;
    }

    void bfs(int r, int c, int[][] land, int cnt){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        isVisited[r][c] = true;
        int sum = 0;

        while(!queue.isEmpty()){
            int[] front = queue.poll();
            sum ++;
            mem[front[0]][front[1]] = cnt;

            for(int d=0; d<4; d++){
                int nr = front[0] + dr[d];
                int nc = front[1] + dc[d];

                if(isIn(nr,nc,R,C) && !isVisited[nr][nc] && land[nr][nc] == 1){
                    queue.offer(new int[]{nr, nc});
                    isVisited[nr][nc] = true;
                }
            }
        }

        // System.out.println(sum);
        map.put(cnt, sum);
    }

    int dr[] = {0, 0, 1, -1};
    int dc[] = {1, -1, 0, 0};

    boolean isIn(int r, int c, int R, int C){
        return (r>=0 && c>=0 && r<R && c<C);
    }
}