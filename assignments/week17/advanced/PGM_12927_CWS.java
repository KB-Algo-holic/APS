// PGM 12927 - 야근지수
// 유형: 큐
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12927

import java.util.*;

class Solution {

    public long solution(int n, int[] works) {

        long answer = 0;

        // 우선순위 큐 -> Collections.reverseOrder()) 역순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int work: works) {
            pq.offer(work);
        }

        // n시간동안 작업 줄이기
        while(n>0) {
            int value = pq.poll();                    // 가장 큰 작업 꺼내고
            pq.offer(value > 0 ? value - 1 : value);  // 1 줄여서 다시 삽입
            n--;
        }

        // 남은 작업 계산
        for(int value: pq) {
            if(value == 0) {
                continue;
            }
            answer += Math.pow(value,2);
        }

        return answer;
    }
}
