// PGM 161989 덧칠하기
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/161989?language=java
// *어렵게 생각하지 않기..


class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] doPaint = new boolean[n+1];
        for (int idx: section) doPaint[idx] = true;
        int last = 0;

        for (int i=1; i<=n; i++) {
            if (i < last) continue;

            if (doPaint[i]) {
                last = i+m;
                answer ++;
            }
        }
        return answer;
    }
}