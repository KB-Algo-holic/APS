// PGM 12909 - 올바른 괄호
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java

import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push('(');
            } else {
                if(st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
        }
        
        answer = st.isEmpty();

        return answer;
    }
}
