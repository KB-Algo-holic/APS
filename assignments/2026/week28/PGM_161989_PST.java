// PGM 161989 - 덧칠하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/161989?language=java

public class PGM_161989_PST {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int paint = 0;

        for (int s : section) {
            if (s > paint) {
                answer++;
                paint = s + m - 1;
            }
        }
        return answer;
    }
}
