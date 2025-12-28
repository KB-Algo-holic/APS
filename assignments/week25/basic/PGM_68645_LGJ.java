// PGM 68645
// 구현
//https://school.programmers.co.kr/learn/courses/30/lessons/68645

import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] tri = new int[n][n];
        int num = 1;
        int x = -1, y = 0; // 시작 전 위치

        for (int i = 0; i < n; i++) {
            for (int step = i; step < n; step++) {
                if (i % 3 == 0) {       // 아래로
                    x++;
                } else if (i % 3 == 1) { // 오른쪽으로
                    y++;
                } else {                 // 좌상단으로
                    x--;
                    y--;
                }
                tri[x][y] = num++;
            }
        }
        //for (int[] r: tri) System.out.println(Arrays.toString(r));

        // 펼치기
        int total = n * (n + 1) / 2;
        int[] answer = new int[total];
        int idx = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c <= r; c++) {
                answer[idx++] = tri[r][c];
            }
        }
        return answer;
    }
}