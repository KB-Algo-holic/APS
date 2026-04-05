package week09;

public class PGM_76502_HSH {
    public static void main(String[] args) {
        String s = "[](){}";
        Solution sol = new Solution();
        int answer = sol.solution(s);
        System.out.println(answer);
    }

    static class Solution {
        int solution(String s) {
            int answer = 0;
            String temp = s;
            // 1. 문자열을 오른쪽으로 계속 밀어야함
            // 2. 최대 길이만큼 회전시키기
            // 3. temp에서 1번부터 끝까지 길이인 문자열 + 0번째 문자열  -> 이 방식을 계속 반복할 것 
            for(int i = 0; i < s.length(); i++) {
                // 처음ㅇ부터 올바른 괄호 문자열 일 수 있으므로 바로 체크
                if(isRight(temp)) {
                    answer++;
                }
                temp = temp.substring(1) + temp.charAt(0);
            }

            return answer;
        }

        boolean isRight(String s) {
            // 4. 올바른 문자열인지 오른쪽으로 이동하면서 괄호를 만드는데, 올바른 괄호가 나오면 문자열에서 빼주면 됨(마치 스택에서 값을 넣는 과정을 하다가 올바른 괄호가 나오면 Pop하듯)
            while(s.contains("{}")|| s.contains("[]") || s.contains("()")) {
                s = s.replace("{}", "");
                s = s.replace("[]", "");
                s = s.replace("()", "");
            }

            return s.isEmpty();
        }
    }
}
