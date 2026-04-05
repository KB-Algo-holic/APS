import java.util.*;
import java.io.*;

/*
요구사항 : 올바른 괄호('('로 열렸으면 반드시 ')'로 닫혀야함)인지 확인 
풀이 
    현재 괄호가   '('면 스택에 push
                    ')'면 스택을 peek 해서 괄호 확인
                            스택 속 괄호가 '('면 pop
                            스택 속 괄호가 ')'면 push
    문자열이 끝났는데 스택이 empty가 아니면 false
*/

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (stack.size() != 0 && stack.peek() == '(') stack.pop();
                else stack.push(c);
            }
        }

        if (stack.isEmpty()) answer = true;
        else answer = false;

        return answer;
    }
}
