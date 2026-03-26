// PGM 42748 - K번째수
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42748

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
                
        for(int i = 0; i < commands.length; i++){
            //i-1번째 수부터 j전까지 배열 추출
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            //오름차순정렬            
            Arrays.sort(temp);
            
            answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }
}
