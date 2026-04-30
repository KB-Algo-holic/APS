// PGM 138477 - 명예의전당
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/138477
import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        List<Integer> aList = new ArrayList(); 

        for(int i=0; i < score.length; i++) {
            if(i < k) {
                aList.add(score[i]);
                
            } else {              
                if(score[i] >= aList.get(0)){
                    aList.remove(0);
                    aList.add(score[i]);
                }
            }
            Collections.sort(aList);
            answer[i] = aList.get(0);
        }
        return answer;
    }
}
