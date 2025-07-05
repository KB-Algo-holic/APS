# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 135808 - 과일 장수
# 유형: 연습문제
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/135808

import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        for(int idx=score.length; idx>=m; idx-=m){
            int row = score[idx-m];
            answer = answer + (row * m);
        }
        
        return answer;
    }
}