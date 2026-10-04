// PGM 42860 조이스틱
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/42860


class Solution {

    public int solution(String name) {
        int length = name.length();
        int answer = 0;

        // 1. 상하 이동 비용
        for (int i = 0; i < length; i++) {
            char target = name.charAt(i);

            int up = target - 'A';
            int down = 'Z' - target + 1;

            answer += Math.min(up, down);
        }

        // 2. 좌우 이동 비용
        int move = length - 1;

        for (int i = 0; i < length; i++) {

            // i 다음부터 연속된 A 끝 찾기
            int next = i + 1;

            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            // 오른쪽 먼저 갔다가 되돌아가기
            int rightFirst = 2 * i + (length - next);

            // 왼쪽 먼저 갔다가 되돌아오기
            int leftFirst = i + 2 * (length - next);

            move = Math.min(
                    move,
                    Math.min(rightFirst, leftFirst)
            );
        }

        return answer + move;
    }
}