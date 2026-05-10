// PGM 159993 - 미로탈출
// DFS
// https://school.programmers.co.kr/learn/courses/30/lessons/159993

import java.util.*;

class Solution {

    static char[][] map;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int nx, ny, sx, sy, lx, ly, ex, ey;
    static boolean lever;

    public int solution(String[] maps) {

        nx = maps.length;
        ny = maps[0].length();

        map = new char[nx][ny];
        arr = new int[nx][ny];

        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                arr[i][j] = Integer.MAX_VALUE;
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }else if(map[i][j] == 'L'){
                    lx = i;
                    ly = j;
                }else if(map[i][j] == 'E'){
                    ex = i;
                    ey = j;
                }
            }
        }
        arr[sx][sy] = 0;
        move(sx, sy, 1);

        if(arr[lx][ly] == Integer.MAX_VALUE){
            return -1;
        }else{
            int cnt = arr[lx][ly];
            for(int[] arr : arr){
                Arrays.fill(arr, Integer.MAX_VALUE);
            }
            arr[lx][ly] = cnt;
            move(lx, ly, cnt+1);
            if(arr[ex][ey] == Integer.MAX_VALUE){
                return -1;
            }else{
                return arr[ex][ey];
            }
        }
    }

    static void move(int x, int y, int cnt){
        for(int i = 0; i < 4; i++){
            if(x + dx[i] >= 0 && y + dy[i] >= 0 && x + dx[i] < nx && y + dy[i] < ny){

                if(cnt < arr[x+dx[i]][y+dy[i]]){

                    arr[x+dx[i]][y+dy[i]] = cnt;

                    if(map[x+dx[i]][y+dy[i]] == 'X') continue;

                    if(map[x+dx[i]][y+dy[i]] == 'L'){
                        lever = true;

                    }
                    move(x+dx[i], y+dy[i], cnt + 1);
                }
            }
        }

    }

}