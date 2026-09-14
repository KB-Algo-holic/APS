// PGM 138477 - 명예의 전당 (1)
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/138477?language=java

import java.util.PriorityQueue;

public class PGM_138477_PST {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]);

            if (pq.size() > k) {
                pq.poll();
            }

            answer[i] = pq.peek();
        }

        return answer;
    }
}
