// PGM - 42748
// 구현 - 정렬
// https://school.programmers.co.kr/learn/courses/30/lessons/42748

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];

        for (int c=0; c<len; c++) {
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];
            int[] sliced = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(sliced);
            answer[c] = sliced[k-1];
        }
        return answer;
    }
}