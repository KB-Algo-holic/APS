// PGM 77485 - 행렬 테두리 회전하기
// 문자열
// https://school.programmers.co.kr/learn/courses/30/lessons/77485

import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        int[] answer = new int[queries.length];

        int cnt = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                map[i][j] = cnt++;
            }
        }

        for(int i = 0; i < queries.length; i++){
            int x = queries[i][0] - 1;
            int y = queries[i][1] - 1;
            int nx = queries[i][2] - queries[i][0];
            int ny = queries[i][3] - queries[i][1];

            int temp = map[x][y];
            answer[i] = temp;
            map[x][y] = map[x+1][y];

            //역순으로 한바퀴 이동
            //아래이동
            for(int j = 0; j < nx; j++){
                map[x][y] = map[++x][y];
                answer[i] = Math.min(answer[i],map[x][y]);
            }

            //오른쪽이동
            for(int j = 0; j < ny; j++){
                map[x][y] = map[x][++y];
                answer[i] = Math.min(answer[i],map[x][y]);
            }

            //위로이동
            for(int j = 0; j < nx; j++){
                map[x][y] = map[--x][y];
                answer[i] = Math.min(answer[i],map[x][y]);
            }

            //왼쪽이동
            for(int j = 0; j < ny; j++){
                map[x][y] = map[x][--y];
                answer[i] = Math.min(answer[i],map[x][y]);
            }
            map[x][y+1] = temp;
        }


        return answer;
    }
}