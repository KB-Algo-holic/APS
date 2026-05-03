// PGM - 42626 L2_더맵게
// 우선순위큐
// https://school.programmers.co.kr/learn/courses/30/lessons/42626

import java.util.PriorityQueue;

public class PGM_42626_YHS {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }

        while(pq.size() > 1){
            if(pq.peek() >= K){
                break;
            }
            int first  = pq.poll();
            int second = pq.poll();

            pq.offer(first+second*2);
            answer++;
        }

        if(pq.peek() >= K){
            return answer;
        }

        return -1;
    }
}
