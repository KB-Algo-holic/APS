// PGM 12914 - 멀리 뛰기
// DP
// https://school.programmers.co.kr/learn/courses/30/lessons/12914


import java.util.*;

class Solution {
    public long solution(int n) {
        int[] N = new int[n+1];
        N[0] = 1;
        N[1] = 2;
        for(int i = 2; i < n+1; i++){
            N[i] = (N[i-2] + N[i-1]) % 1234567;

        }
        return N[n-1]%1234567;
    }
}