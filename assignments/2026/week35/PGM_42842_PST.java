// PGM 42842 - 카펫
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42842?language=java

public class PGM_42842_PST {
    public int[] solution(int brown, int yellow) {

        int totalSum = brown + yellow;

        for (int h = 3; h <= Math.sqrt(totalSum); h++) {

            if (totalSum % h == 0) {
                int w = totalSum / h;

                if ((w - 2) * (h - 2) == yellow) {
                    return new int[] { w, h };
                }
            }
        }

        return new int[] {};
    }
}
