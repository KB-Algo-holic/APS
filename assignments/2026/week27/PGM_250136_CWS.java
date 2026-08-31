// PGM 250136 - 석유 시추
// BFS, DFS
// https://school.programmers.co.kr/learn/courses/30/lessons/250136

import java.util.*;

class Solution {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] lands;
    static boolean visited[][];
    static int cnt;
    static Set<Integer> colSet;
    static int[] oil;

    public int solution(int[][] land) {

        lands = land;
        visited = new boolean[land.length][land[0].length];
        oil = new int[land[0].length];

        for(int i = 0; i < lands.length; i++){
            for(int j = 0; j < lands[0].length; j++){
                if(lands[i][j] == 1 && !visited[i][j]){
                    cnt = 1;
                    colSet = new HashSet<>();
                    colSet.add(j);

                    bfs(i, j);

                    for(int col : colSet){
                        oil[col] += cnt;
                    }
                }
            }
        }

        int answer = 0;
        for(int val : oil){
            answer = Math.max(answer, val);
        }

        return answer;
    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >= 0 && ny >= 0 && nx < lands.length && ny < lands[0].length
                   && lands[nx][ny] == 1 && !visited[nx][ny] ){
                    visited[nx][ny] = true;
                    colSet.add(ny);
                    cnt++;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}