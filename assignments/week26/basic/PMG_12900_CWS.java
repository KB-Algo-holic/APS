// PGM 12900 - 2 * 타일링
// 유형: DP
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12900

import java.util.*;

class Solution {
    public long solution(int n) {

        long[] arr = new long[n+1];

        arr[1] = 1;
        arr[2] = 2; //기본 2

        for(int i = 3; i <= n; i++){
            arr[i] = (arr[i-2] + arr[i-1]) % 1000000007;
        }

        return arr[n];
    }
}
