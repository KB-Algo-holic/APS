// PGM 12914 - 멀리 뛰기
// 학습  
// https://school.programmers.co.kr/learn/courses/30/lessons/12914?language=java
class Solution {

    public long solution(int n) {
        if (n <= 2) return n;

        long[] d = new long[n + 1];
        d[1] = 1L;
        d[2] = 2L;
        
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 1234567;
        }

        return d[n];
    }

}
