// [PGM] 138477 - 명예의전당(1)
// 우선순위큐로 구현
// school.programmers.co.kr/learn/courses/30/lessons/138477
import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ans = new int[score.length];
        int idx = 0;
        for(int i: score){
            if(pq.size() < k){
                pq.offer(i);
            }
            else{
                if(pq.peek() < i){
                    pq.poll();
                    pq.offer(i);
                }
            }
            ans[idx++] = pq.peek();
        }
        return ans;
    }
}
