# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 12909 - 올바른 괄호
# 유형: 스택/큐큐
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12909

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