# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 42840 - 모의고사
# 유형: 정렬
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42840

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] stu1 = {1,2,3,4,5};
        int[] stu2 = {2,1,2,3,2,4,2,5};
        int[] stu3 = {3,3,1,1,2,2,4,4,5,5};
        
        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;
        
        for(int idx = 0; idx < answers.length; idx++) {
            int question = answers[idx];
            
            int rowIdx = rowIdx = (idx % stu1.length);
            if(question == stu1[rowIdx]) answer1++;
            
            rowIdx = (idx % stu2.length);
            if(question == stu2[rowIdx]) answer2++;
            
            rowIdx = (idx % stu3.length);
            if(question == stu3[rowIdx]) answer3++;
        }
        
        int maxCnt = Math.max(answer1, Math.max(answer2,answer3));
        
        List<Integer> list = new ArrayList<Integer>();
        if(maxCnt == answer1) list.add(1);
        if(maxCnt == answer2) list.add(2);
        if(maxCnt == answer3) list.add(3);
        
        int[] winner = new int[list.size()];
        for (int i=0; i<list.size(); i++){
            winner[i] = list.get(i);
        }
        
        return winner;
    }
}