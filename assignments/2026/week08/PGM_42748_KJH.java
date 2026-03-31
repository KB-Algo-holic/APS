// PGM 42748 - K번째수
// 구현
//https://school.programmers.co.kr/learn/courses/30/lessons/42748

import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
         
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int s = commands[i][0];  
            int e = commands[i][1];  
            int k = commands[i][2];  

            int[] temp = Arrays.copyOfRange(array, s - 1, e);

            Arrays.sort(temp);

            answer[i] = temp[k - 1];
        }

        return answer;
    }
}
