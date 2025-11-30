// PGM 12902 - 3 * 타일링
// 유형: DP
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12902

import java.util.*;

class Solution {
    public long solution(int n) {

        long[] arr = new long[n+1];


        arr[0] = 1;
        arr[2] = 3; //기본 3
        // 홀수 제외
        for(int i = 4; i <= n; i+=2){
            // arr[i] = arr[i-2] * 3
            arr[i] = arr[i-2] * 3 % 1000000007;

            // 대칭 되는 모양 2가지씩 곱하기
            for(int j = i-4; j >= 0; j-=2){
                arr[i] = (arr[i] + arr[j] * 2) % 1000000007;
            }
        }

        return arr[n];
    }
}
