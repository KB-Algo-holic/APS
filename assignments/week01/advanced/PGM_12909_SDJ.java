# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 12909 - 올바른 괄호
# 유형: 스택/큐
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        if(s.charAt(0) != '(') return false;
        if(s.length() < 1) return false;
        
        int leftChar = 0;
        int rightChar = 0;
        
        for(int idx=0; idx<s.length(); idx++){
            char cc = s.charAt(idx);
            
            if(cc == '(') leftChar++;
            if(cc == ')') rightChar++;
        }
        
        if(leftChar == rightChar) {
            answer = true;
        }


        return answer;
    }
}