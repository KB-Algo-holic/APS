// PGM - 147354
// 구현 (정렬, 비트연산)
// https://school.programmers.co.kr/learn/courses/30/lessons/147354?language=java

import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int idx = col-1;
        Arrays.sort(data, (o1, o2) -> {
            if (o1[idx] == o2[idx]) return Integer.compare(o2[0], o1[0]);
            else return Integer.compare(o1[idx], o2[idx]);
        });

        for (int i=row_begin-1; i<=row_end-1; i++) {
            int[] row = data[i];
            int sum = 0;
            for (int value: row) {
                sum += value % (i+1);
            }
            answer ^= sum;
        }
        return answer;
    }
}