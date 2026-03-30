package week09;
import java.util.Stack;

public class PGM_12909_HSH {
    public static void main(String[] args) {
        String s = "()()";
        Solution sol = new Solution();
        boolean answer = sol.solution(s);
        System.out.println(answer);
    }

    static class Solution {
        boolean solution(String s) {
            boolean answer = true;
            Stack<String> stack = new Stack<String>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        // 처음부터 ) 이게 들어온 경우는 할 필요가 없음
                        answer = false;
                        break;
                    }
                } else {
                    stack.push(String.valueOf(s.charAt(i)));
                }
            }

            if (!stack.isEmpty())
                answer = false;
            return answer;
        }
    }
}
