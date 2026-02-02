// PGM 76502 - 괄호 회전하기
// 스택, 큐
// https://school.programmers.co.kr/learn/courses/30/lessons/76502

import java.util.*;

class Solution {

    boolean isCorrect() {
        return true;
    }

    public int solution(String s) {
        int answer = 0;

        Deque<Character> bracketStack = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {
            bracketStack.add(s.charAt(i));
        }

        Deque<Character> openStack = new LinkedList<>();
        char bracketFront, openFront;
        boolean isBalanced;

        for(int time = 0; time < s.length(); time++) {

            openStack.clear();
            isBalanced = true;

            for(int i = 0 ; i < bracketStack.size(); i++) {
                bracketFront = bracketStack.pollFirst();
                bracketStack.offerLast(bracketFront);

                if(bracketFront == ')' || bracketFront == '}' || bracketFront == ']') {
                    if(openStack.size() > 0) {
                        openFront = openStack.pollFirst();
                        if( (bracketFront == ')' && openFront == '(') || (bracketFront == '}' && openFront == '{') || (bracketFront == ']' && openFront == '[') ) {
                        } else {
                            isBalanced = false;
                        }
                    } else {
                        isBalanced = false;
                    }
                } else {
                    openStack.offerFirst(bracketFront);
                }
            }

            if(isBalanced && openStack.size() == 0) {
                answer++;

            }

            bracketFront = bracketStack.pollFirst();
            bracketStack.offerLast(bracketFront);
        }

        return answer;
    }
}