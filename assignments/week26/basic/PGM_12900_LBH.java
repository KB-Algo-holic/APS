// PGM 12900 - 2 x n 타일링
// DP
// https://school.programmers.co.kr/learn/courses/30/lessons/12900

class Solution {
    public int solution(int n) {
        long[] fibonnaci = new long[n];
        fibonnaci[0] = 1L;
        fibonnaci[1] = 2L;
        
        for(int i = 2; i < n; i++) {
            fibonnaci[i] = (long)((fibonnaci[i-1] + fibonnaci[i-2]) % 1000000007L);
        }
        
        return (int)fibonnaci[n-1];
    }
}