package week06;
import java.util.Stack;

public class PGM_12973_HSH {

    public static void main(String[] args) {
        PGM_12973_HSH sol = new PGM_12973_HSH();

        int result = sol.solution("baabaa");

        System.out.println(result);

    }

    public int solution(String s) {
        String result = s.toLowerCase();
        /**
         * 1) 같은 알파벳이 2개 붙어 있는 짝 구하기 -> 둘 제거 -> 앞뒤로 문자열을 이어 붙이 2) 1) 반복 -> 문자열 모두 제거 ->
         * 짝짓기 종료 3) 다음 작업을 할 수 있으면 1, 아니면 0 리턴
         */
        String firstStr = String.valueOf(result.charAt(0));
        Stack<String> stack = new Stack<>();
        stack.push(firstStr); // 맨 처음꺼는 넣어서 시
        for (int i = 1; i < result.length(); i++) {

            if (stack.isEmpty()) {
                firstStr = ""; // 다 비워졌다면 공백으로 처리
            } else {
                firstStr = stack.peek(); // 비워져 있지 않다면 스택 맨 위에꺼로 체크
            }
            // 스택에 맨 위에 있는 것과 문자열 다음꺼가 동일한 거면 스택 비우기
            if (firstStr.equals(String.valueOf(result.charAt(i)))) {
                stack.pop();
            }
            // 스택에 맨 위에 있는 것과 문자열 다음꺼가 동일하지 않다면 스택에 채우기
            else {
                stack.push(String.valueOf(result.charAt(i)));
            }

        }

        if (stack.isEmpty()) {
            return 1;
        }
        
        return 0;
    }
}
