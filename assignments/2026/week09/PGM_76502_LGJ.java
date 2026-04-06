// PGM - 76502 괄호회전하기
// Stack
// https://school.programmers.co.kr/learn/courses/30/lessons/76502

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        String doubled = s + s;

        for (int i = 0; i < n; i++) {
            if (isRight(doubled.substring(i, i + n))) {
                answer++;
            }
        }

        return answer;
    }


    public boolean isRight(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '{' || cur == '[' || cur == '(') {
                stack.push(cur);
            } else if (stack.isEmpty()) return false;
            else {
                char last = stack.peek();
                if ((last == '{' && cur == '}') || (last == '[' && cur == ']') || (last == '(' && cur == ')')) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
