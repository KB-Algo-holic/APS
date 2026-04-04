// PGM - 12909 올바른 괄호
// 스택
// https://school.programmers.co.kr/learn/courses/30/lessons/12909

import java.util.*;

class Solution {
    boolean solution(String s) {

        Stack<String> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(String.valueOf(c));
            } else {
                if (stack.isEmpty()) return false;
                else if (stack.peek().equals(String.valueOf(')'))) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty() ? true : false;
    }
}