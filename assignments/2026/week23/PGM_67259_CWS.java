// PGM 67259 - 경주로 건설
// 최단경로
// https://school.programmers.co.kr/learn/courses/30/lessons/67259

import java.util.*;

class Solution {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] boards;
    static int[][][] map;
    static int answer;

    public int solution(int[][] board) {

        boards = board;
        map = new int[board.length][board[0].length][4];
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                Arrays.fill(map[i][j], Integer.MAX_VALUE);
            }
        }
        answer = Integer.MAX_VALUE;
        move(0,0,0,0,0,0);

        return answer;
    }
    public static void move(int x, int y, int mx, int my, int sum, int dir){
        if(map[x][y][dir] < sum) return;
        else map[x][y][dir] = sum;
        if(x==boards.length-1 && y==boards[0].length-1) {
            answer = Math.min(answer, sum);
            return;
        }

        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx >= 0 && ny >= 0 && nx < boards.length && ny < boards[0].length){
                if(boards[nx][ny] == 0){
                    int nextSum = sum;
                    if(mx == 0 && my == 0) nextSum += 100;
                    else if(dx[k] == mx && dy[k] == my) nextSum += 100;
                    else nextSum += 600;
                    move(nx, ny, dx[k], dy[k], nextSum, k);
                }
            }
        }


    }

}