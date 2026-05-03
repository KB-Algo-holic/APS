// 명예의 전당 (1)
// 우선순위 큐
// https://school.programmers.co.kr/learn/courses/30/lessons/138477

import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {

        int[] answer = new int[score.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < score.length; i++){
            pq.add(score[i]);
            for(int j = 0; j < k && pq.size() > 0; j++) {
                int t = pq.poll();
                if(j == (k - 1) || pq.size() == 0 ){
                    answer[i] = t;
                }
            }

            for(int j = 0; j <= i; j++){
                pq.add(score[j]);
            }
        }

        return answer;
    }
}