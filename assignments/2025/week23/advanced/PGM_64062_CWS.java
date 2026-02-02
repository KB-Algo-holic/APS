// PGM 60462 - 징검다리 건너기
// 유형: 이분탐색
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/64062

import java.util.*;

class Solution {

    public int solution(int[] stones, int k) {

        int low = 1;
        int high = 200_000_000; // 최대 값
        int answer = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // mid명이 건널 수 있으면 더 많은 인원 시도
            if (isPossible(stones, k, mid)) {
                answer = mid;
                low = mid + 1;
            } else { // 불가능하면 인원 줄이기
                high = mid - 1;
            }
        }

        return answer+1;
    }

    // mid명이 건널 수 있는지 판별
    private boolean isPossible(int[] stones, int k, int mid) {
        int z = 0; // 연속된 0의 개수

        for (int stone : stones) {
            if (stone - mid <= 0) { // 돌이 0 이하가 되면 못 밟음
                z++;
            } else {
                z = 0; // 밟을 수 있으면 연속 끊김
            }

            if (z >= k) { // 연속된 0이 k 이상이면 건널 수 없음
                return false;
            }
        }

        return true;
    }
}
