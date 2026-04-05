// PGM 12909 - 올바른 괄호
// 스택
// https://school.programmers.co.kr/learn/courses/30/lessons/12909

import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> openStack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                openStack.offerLast('(');
            } else if(openStack.size() > 0) {
                openStack.pollLast();
            } else {
                return false;
            }
        }
        
        return openStack.size() == 0 ? true : false;
    }
}