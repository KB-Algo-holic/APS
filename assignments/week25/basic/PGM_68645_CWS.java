// PGM 68645 - 삼각달팽이
// 유형: 시뮬레이션
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/68645

import java.util.*;

class Solution {
    static int[][] map;
    static int num;

    public int[] solution(int n) {

        map = new int[n][n];
        num = 1;
        down(n, 0, 0);

        int[] answer = new int[num - 1];
        num = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[num++] = map[i][j];
            }
        }
        return answer;
    }

    // 아래 방향으로 n
    private static void down(int n, int x, int y){
        for(int i = 0; i < n; i++){
            map[x++][y] = num++; // 아래로 이동
        }
        if(n == 1) return; // 마지막 한 칸이면 종료

        right(n - 1, x - 1, y + 1);
    }

    // 오른쪽 방향으로 n
    private static void right(int n, int x, int y){
        for(int i = 0; i < n; i++){
            map[x][y++] = num++; // 오른쪽으로 이동
        }
        if(n == 1) return;

        leftUp(n - 1, x - 1, y - 2);
    }

    // 왼쪽 위 방향으로 n
    private static void leftUp(int n, int x, int y){
        for(int i = 0; i < n; i++){
            map[x--][y--] = num++; // 좌상향 이동
        }
        if(n == 1) return;

        down(n - 1, x + 2, y + 1);
    }
}
