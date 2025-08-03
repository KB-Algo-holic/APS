# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 12945 - 피보나치 수
# 유형: 동적계획법
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12945

import java.util.*;

class Solution {
    public int solution(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            memo[i] = (memo[i - 2] + memo[i - 1]) % 1234567;
        }
        
        return memo[n];
    }
}