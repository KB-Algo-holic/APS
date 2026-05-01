import java.util.PriorityQueue;

// PGM - 138477 L1_명예의전당1
// 우선순위큐
// https://school.programmers.co.kr/learn/courses/30/lessons/138477
public class PGM_138477_YHS {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<score.length; i++){
            if(pq.size() <= k){
                pq.offer(score[i]);
            }

            if(pq.size() > k){
                pq.poll();
            }

            answer[idx++] = pq.peek();
        }

        return answer;
    }
}
