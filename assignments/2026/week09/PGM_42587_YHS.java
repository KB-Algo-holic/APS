// PGM - 42587 프로세스
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42587

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PGM_42587_YHS {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Node> queue = new LinkedList<>();

        int size = priorities.length;
        for(int i=0; i<size; i++){
            pq.offer(priorities[i]);
            queue.offer(new Node(priorities[i], i));
        }

        while(!queue.isEmpty()){
            Node front = queue.poll();

            if(front.p == pq.peek()){
                pq.poll();
                answer++;
                if(front.l == location){
                    break;
                }
            }else{
                queue.offer(front);
            }
        }

        return answer;
    }

    class Node{
        int p;
        int l;

        public Node(int p, int l){
            this.p = p;
            this.l = l;
        }
    }
}
