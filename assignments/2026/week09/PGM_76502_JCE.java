
import java.util.Stack;

/**
* 요구사항: 대괄호, 중괄호, 소괄호로 이루어진 문자열 s를 왼쪽으로 x칸만큼 회전시켰을 때, s가 올바른 괄호 문자열이 되게 하는 x의 개수를 구합니다.
* 올바른 괄호 문자열: (), {}, [], ([]), {}([]), …
*/
public class Solution {

    public static int solution(String s) {
        int answer = 0;
        String rotatedString = "";
        for (int i = 0; i < s.length(); i++) {
            // 올바른 괄호 문자열인지 확인
            if (isCorrect(s)) {
                answer++;
            }
            // s 문자열을 한 칸씩 왼쪽으로 회전
            rotatedString = rotateToLeft(s);
            s = rotatedString;
        }
        return answer;
    }

    private static boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // 짝맞는 괄호가 있으면 스택에서 빼기, 아니면 일단 넣기
            if (stack.size() != 0) {
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
                if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                    continue;
                }
                if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
                stack.push(c);
            } else {  // 첫번째 괄호는 우선 넣기
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    // 문자열을 왼쪽으로 한 칸 이동시키는 함수
    private static String rotateToLeft(String s) {
        StringBuffer sb = new StringBuffer();
        sb.append(s.substring(1)).append(s.charAt(0));
        return sb.toString();
    }
}
