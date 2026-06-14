// PGM 43238 입국심사
// 이분탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/43238?language=java


class Solution {
    public long solution(int n, int[] times) {

        int maxTime = 0;
        for (int time : times) maxTime = Math.max(time, maxTime);

        long start = 0;
        long end = maxTime*(n+1);

        while (start < end) {
            long mid = (start+end) / 2; // 최소시간 후보
            int total = 0; // 최소시간 내 할 수 있는 인원 총합

            for (int time: times) {
                total += (mid / time); // mid 시간 동안 각 심사관들이 맡을 수 있는 인원수
            }

            if (total >= n) end = mid; //n보다 크면 줄이기
            else start = mid+1; //작으면 늘리기
        }

        return start;
    }
}