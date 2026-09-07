// PGM 76502 - 괄호 회전하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/76502?language=java

import java.util.ArrayList;
import java.util.List;

public class PGM_76502_PST {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();

        if (n % 2 != 0) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            String rotated = s.substring(i) + s.substring(0, i);

            if (isValid(rotated)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {

                stack.add(c);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.get(stack.size() - 1);

                if ((c == ')' && top == '(') ||
                        (c == ']' && top == '[') ||
                        (c == '}' && top == '{')) {
                    stack.remove(stack.size() - 1);
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
