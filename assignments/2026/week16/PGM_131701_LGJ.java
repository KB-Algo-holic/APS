// PGM 131701 연속 부분 수열 합의 개수
// 구현 - 누적함
// https://school.programmers.co.kr/learn/courses/30/lessons/131701?language=java

import java.util.*;

class Solution {
    public int solution(int[] elements) {

        int n = elements.length;

        // 원형 배열
        int[] arr = new int[n * 2];

        for (int i = 0; i < n; i++) {
            arr[i] = elements[i];
            arr[i + n] = elements[i];
        }

        // prefix sum 미리 계산
        int[] prefix = new int[n * 2 + 1];

        for (int i = 0; i < n * 2; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        Set<Integer> set = new HashSet<>();

        // 길이
        for (int length = 1; length <= n; length++) {

            // 시작점
            for (int start = 0; start < n; start++) {

                int sum =
                        prefix[start + length]
                                - prefix[start];

                set.add(sum);
            }
        }

        return set.size();
    }
}