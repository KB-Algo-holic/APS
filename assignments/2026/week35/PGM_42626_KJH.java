// PGM 42626 - 더맵게
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42626
import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }
         
        while (pq.peek() < K) { 
            if (pq.size() < 2) {
                return -1;
            }
            
            int first = pq.poll();       
            int second = pq.poll();     
            
            int mixed = first + (second * 2);
            pq.offer(mixed);
            answer++;
        }
        return answer;
    }
}
