# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 12939 - 최댓값과 최솟값
# 유형: 연습문제
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12939

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        int leftChar = 0;
        int rightChar = 0;
        
        for(int idx=0; idx<s.length(); idx++){
            char cc = s.charAt(idx);
            
            if(cc == '(') {
                leftChar++;
            }
            if(cc == ')'){
                rightChar++;  
            }
            //닫힘기호가 많아지면 에러(무조건 열린 후 닫혀야함)
            if(leftChar < rightChar) {
                return false;
            }
        }
        System.out.println("left = " + leftChar);
        System.out.println("rightChar = " + rightChar);
        
        if(leftChar == rightChar) {
            answer = true;
        }
        return answer;
    }
}