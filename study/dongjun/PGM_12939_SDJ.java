# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 12939 - 최대값과 최소값
# 유형: 연습문제제
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12939

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] tempStr = s.split(" ");
        int[] list = new int[tempStr.length];
        
        //(-) 음수의 경우 String로 정렬하면 안되서 Int로 형변환하여 정렬
        for(int i =0; i<tempStr.length; i++) {
            list[i] = Integer.parseInt(tempStr[i]);
        }
        
        Arrays.sort(list);
        
        answer = list[0] + " " + list[list.length-1];
        
        return answer;
    }
}