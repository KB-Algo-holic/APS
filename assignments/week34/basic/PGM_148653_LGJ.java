// PGM - 148653
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/148653?language=java


class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int n = storey % 10;         // 현재 자리
            int next = (storey / 10) % 10; // 다음 자리

            if (n > 5 || (n == 5 && next >= 5)) {
                answer += (10 - n);
                storey += 10; // 올림 발생
            } else {
                answer += n;
            }
            storey /= 10;
        }

        return answer;
    }
}
