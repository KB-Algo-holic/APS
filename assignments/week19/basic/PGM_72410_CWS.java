// PGM 72410 - 신규 아이디 추천
// 유형: 문자열
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/72410

class Solution {
    public String solution(String new_id) {
        String s = "~!@#$%^&*()=+[{]}:?,<>/";

        // 1. 대문자 -> 소문자
        new_id = new_id.toLowerCase();

        // 2. 허용된 문자만 남기기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            boolean t = true;
            for (int j = 0; j < s.length(); j++) {
                if (c == s.charAt(j)) {
                    t = false;
                    break;
                }
            }
            if (t) {
                sb.append(c);
            }
        }

        // 3. 마침표 2개 이상이면 하나로
        String answer = sb.toString();
        sb = new StringBuilder();
        boolean dot = false;
        for (int i = 0; i < answer.length(); i++) {
            char c = answer.charAt(i);
            if (c == '.') {
                if (!dot) {
                    sb.append(c);
                    dot = true;
                }
            } else {
                sb.append(c);
                dot = false;
            }
        }

        // 4. 처음과 끝의 . 제거
        answer = sb.toString();
        if (answer.length() > 0 && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }
        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }

        // 5. 빈 문자열이면 a
        if (answer.length() == 0) {
            answer = "a";
        }

        // 6. 길이가 16 이상이면 15자까지만, 끝이 .이면 제거
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        // 7. 길이가 2 이하이면 마지막 문자를 3자가 될 때까지 반복
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }
}