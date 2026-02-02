// PGM 250135 - 아날로그 시계
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/250135

public class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int result = getCount(h2, m2, s2) - getCount(h1, m1, s1);
        if (s1 == 0 && m1 == 0) result += 1;
        return result;
    }

    private int getCount(int h, int m, int s) {
        int mCount = 0;
        int hCount = 0;

        mCount += h * 59;
        hCount += h * 60;

        int result = 0;

        mCount += m;
        hCount += m;
        result -= 1;

        int curMDegree = m * 6;
        double curHDegree = 30 * (h % 12) + 0.5 * m;
        boolean condition1 = curMDegree <= 5.9 * s;
        boolean condition2 = curHDegree <= (6 - 1 / 120) * s;

        if (condition1) mCount += 1;
        if (condition2) hCount += 1;

        if (h >= 12) {
            hCount -= 1;
            result -= 1;
        }

        result += mCount + hCount;

        return result;
    }
}