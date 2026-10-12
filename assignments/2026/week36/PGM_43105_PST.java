// PGM 43105 - 정수 삼각형
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=java

public class PGM_43105_PST {
    public int solution(int[][] triangle) {
        int height = triangle.length;

        for (int i = height - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {

                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        return triangle[0][0];
    }
}
