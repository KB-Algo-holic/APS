# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 42748 - K번째수
# 유형: 정렬
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42748

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int idx=0; idx<answer.length; idx++) {
            int[] row =  commands[idx];
            
            int[] tempArr = Arrays.copyOfRange(array, row[0]-1, row[1]);
            Arrays.sort(tempArr);
            
            answer[idx] = tempArr[row[2]-1];
            

        }
        
        return answer;
    }
}
