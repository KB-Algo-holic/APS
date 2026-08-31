// PGM 72410 - 신규아이디추천
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/72410
class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();

        answer = answer.replaceAll("[^a-z0-9-_.]", "");

        answer = answer.replaceAll("\\.+", ".");

        answer = answer.replaceAll("^[.]|[.]$", "");

        if (answer.isEmpty()) {
            answer = "a";
        }

        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }

        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }
        return answer;
    }
}
