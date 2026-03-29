// PGM 42748 - K번째수
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42748

import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0;i<commands.length;i++)
        {
            int[] temp = new int[ commands[i][1] - commands[i][0] +1];
            // System.out.println(temp.length);
            int idx = 0;
            
            for(int j= commands[i][0]-1;j<commands[i][1];j++)
            {
                temp[idx] = array[j];
                idx++;
            }
            
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }
}
