// PGM 250136 - 석유시추
// 유형: BFS
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/250136

import java.util.*;

class Solution {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] lands;
    static boolean visited[][];
    static int cnt; //덩어리 크기
    static Set<Integer> colSet; //덩어리 차지 열
    static int[] oil; //열별 누적량

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

                    //탐색 끝난 뒤 열별 누적
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

    //DFS로 풀경우 런타임에러
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
                    colSet.add(ny);   // 열 정보 저장
                    cnt++;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}