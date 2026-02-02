// PGM 42840 - 모의고사
// 유형: 완전탐색
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42840

import java.util.*;

class Solution {
    public int[] getWhoisBest(int a, int b, int c) {
        int max = 0;
        if (a > max) max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        
        ArrayList<Integer> arr = new ArrayList<>();
        if (a == max) arr.add(1);
        if (b == max) arr.add(2);
        if (c == max) arr.add(3);
        
        int[] answer = new int[arr.size()];
        for (int i=0; i<answer.length; i++) answer[i] = arr.get(i);
        return answer;
    }
    public int[] solution(int[] answers) {
        int[] answers_1 = new int[] {1,2,3,4,5};
        int[] answers_2 = new int[] {2,1,2,3,2,4,2,5};
        int[] answers_3 = new int[] {3,3,1,1,2,2,4,4,5,5};
        int answer_1 = 0;
        int answer_2 = 0;
        int answer_3 = 0;
        
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == answers_1[i%5]) answer_1 += 1;
            if (answers[i] == answers_2[i%8]) answer_2 += 1;
            if (answers[i] == answers_3[i%10]) answer_3 += 1;
        }
        
        int[] answer = getWhoisBest(answer_1, answer_2, answer_3);
        return answer;
    }
}