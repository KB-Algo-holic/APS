// K번째수
// 정렬
// https://school.programmers.co.kr/learn/courses/30/lessons/42748

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {

            int[] cuttedArray = new int[commands[i][1] - commands[i][0] + 1];
            System.arraycopy(array, commands[i][0] - 1, cuttedArray, 0, cuttedArray.length);

            Arrays.sort(cuttedArray);

            answer[i] = cuttedArray[commands[i][2] - 1];
        }

        return answer;
    }
}