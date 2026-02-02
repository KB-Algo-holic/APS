// PGM - 피보나치수
// DP
// https://school.programmers.co.kr/learn/courses/30/lessons/12945


class Solution {
    public int solution(int n) {
        int[] fiboArr = new int[n+1];
        fiboArr[0] = 0;
        fiboArr[1] = 1;
        for (int i=2; i<=n; i++) {
            fiboArr[i] = (fiboArr[i-2] + fiboArr[i-1]) % 1234567;
        }
        return fiboArr[n];
    }

}
