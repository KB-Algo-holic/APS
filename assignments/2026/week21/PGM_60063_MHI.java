// PGM 60063 - 블록 이동하기
// BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/60063

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[] dc = {0, 1, 0, -1};
    static int[] dr = {1, 0, -1, 0};

    static int[] r = {-1, 1};

    public static void main(String[] args) throws Exception{
        int[][] board = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
        System.out.println(solution(board));
    }
    static public int solution(int[][] board) {

        Queue<Robot> q = new LinkedList<>();
        int n = board.length;
        int ans=0;
        boolean[][][][] visited = new boolean[n][n][n][n];
        q.add(new Robot(0,0,0,1,0));
        while(!q.isEmpty()) {
            Robot now = q.poll();
            if(visited[now.c1][now.r1][now.c2][now.r2]) continue;
            visited[now.c1][now.r1][now.c2][now.r2]=true;
            visited[now.c2][now.r2][now.c1][now.r1]=true;
            if((now.c1==n-1&&now.r1==n-1)||(now.c2==n-1&&now.r2==n-1)) {
                ans=now.dist;
                break;
            }

            for(int i=0; i<4; i++) {
                int nextC1 = now.c1+dc[i];
                int nextR1 = now.r1+dr[i];
                int nextC2 = now.c2+dc[i];
                int nextR2 = now.r2+dr[i];
                if(0<=nextC1&&nextC1<n&&0<=nextR1&&nextR1<n&&0<=nextC2&&nextC2<n&&0<=nextR2&&nextR2<n) {
                    if(board[nextC1][nextR1]==0&&board[nextC2][nextR2]==0) {
                        q.add(new Robot(nextC1,nextR1, nextC2,nextR2, now.dist+1));
                    }
                }
            }
            if(now.c1==now.c2) {
                for(int i=0; i<2; i++) {
                    int nextC=now.c1+r[i];
                    if(0<=nextC&&nextC<n&&board[nextC][now.r1]==0&&board[nextC][now.r2]==0) {
                        q.add(new Robot(nextC,now.r2, now.c2,now.r2, now.dist+1));
                        q.add(new Robot(now.c1,now.r1, nextC,now.r1, now.dist+1));
                    }
                }
            }
            if(now.r1==now.r2) {
                for(int i=0; i<2; i++) {
                    int nextR=now.r1+r[i];
                    if(0<=nextR&&nextR<n&&board[now.c1][nextR]==0&&board[now.c2][nextR]==0) {
                        q.add(new Robot(now.c2,nextR, now.c2,now.r2, now.dist+1));
                        q.add(new Robot(now.c1,now.r1, now.c1,nextR, now.dist+1));
                    }
                }
            }
        };
        return ans;
    }
    static class Robot{
        int c1, r1, c2, r2, dist;
        Robot(int c1, int r1, int c2, int r2, int dist){
            this.r1=r1;
            this.c1=c1;
            this.r2=r2;
            this.c2=c2;
            this.dist=dist;
        }
    }
}