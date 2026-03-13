// 짝지어 제거하기
// 문자열, 스택
// https://school.programmers.co.kr/learn/courses/30/lessons/12973

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char next = s.charAt(i);

            if(stack.size() > 0) {
                char top = stack.peek();

                if(top == next) {
                    stack.pop();
                    continue;
                }
            }

            stack.push(next);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}