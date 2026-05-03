// 명예의 전당 (1)
// 우선순위 큐
// https://school.programmers.co.kr/learn/courses/30/lessons/138477

import java.util.*;
class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        for(int i=0;i<score.length;i++){
            pq.add(score[i]);
            if(pq.size()>k){
                pq.poll();
            }
            answer[i] = pq.peek();
        }
        return answer;
    }
}