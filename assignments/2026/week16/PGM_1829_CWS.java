// PGM 1829 - 카카오프렌즈 컬러링북
// DFS/BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/1829

import java.util.*;

class Solution {

    static int M, N, cnt;
    static int[][] arr;

    public int[] solution(int m, int n, int[][] picture) {

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        M = m;
        N = n;
        arr = picture.clone();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] > 0){
                    cnt = 1;
                    numberOfArea++;
                    chk(i,j,picture[i][j]);
                    maxSizeOfOneArea = Math.max(cnt,maxSizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void chk(int x, int y, int c){

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        arr[x][y] = -1;

        for(int i = 0; i < 4; i++){
            if(x+dx[i] >= 0 && y+dy[i] >= 0 && x+dx[i] < M && y+dy[i] < N){
                if(arr[x+dx[i]][y+dy[i]]==c){
                    cnt++;
                    chk(x+dx[i],y+dy[i], c);
                }
            }
        }




    }
}