// PGM - 충돌위험찾기
// 시뮬레이션
// https://school.programmers.co.kr/learn/courses/30/lessons/340211
// 학일님 풀이 참고..

import java.util.*;
class Solution{
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int[][][] timeBoard = new int[20000][101][101];

        for (int[] route: routes) {
            int start = route[0]-1;
            int sR = points[start][0]-1;
            int sC = points[start][1]-1;
            int time = 0;

            timeBoard[time][sR][sC]++;
            if (timeBoard[time][sR][sC] == 2) { answer += 1; }

            for (int end: route) {
                int eR = points[end-1][0] -1;
                int eC = points[end-1][1] -1;

                while (sR != eR) {
                    time ++;
                    sR += sR < eR ? 1 : -1;
                    timeBoard[time][sR][sC]++;
                    if (timeBoard[time][sR][sC] == 2) { answer +=1; }
                }

                while (sC != eC) {
                    time ++;
                    sC += sC < eC ? 1 : -1;
                    timeBoard[time][sR][sC]++;
                    if (timeBoard[time][sR][sC] == 2) { answer +=1; }
                }
            }
        }
        return answer;

    }

}