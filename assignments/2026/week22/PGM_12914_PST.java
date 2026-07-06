// PGM 12914 - 멀리 뛰기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12914?language=java

public class PGM_12914_PST {
    public long solution(int n) {

        if (n == 1) {
            return 1;
        }

        long[] answerArray = new long[n + 1];

        answerArray[1] = 1;
        answerArray[2] = 2;

        for (int i = 3; i <= n; i++) {
            answerArray[i] = (answerArray[i - 1] + answerArray[i - 2]) % 1234567;
        }

        return answerArray[n];
    }
}
