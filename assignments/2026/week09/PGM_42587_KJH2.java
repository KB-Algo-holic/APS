// PGM_42587 프로세스
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42587

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pri_queue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>(); // 우선순위, 실제인덱스
        int cnt = 0;
        // 큐에 값 넣기..
        if(priorities.length == 0)
            return 0;
        for(int i = 0 ; i < priorities.length; i++){
            int[] pair = {priorities[i], i};
            queue.add(pair);
            pri_queue.add(priorities[i]);
        }
        
        // 우선순위 및 인덱스 비교
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            // 우선순위가 낮으면..
            if(tmp[0] < pri_queue.peek()){
                queue.add(tmp);
            }
            // 우선순위가 같으면서 index위치도 같으면..
            else if(tmp[0] == pri_queue.peek() && tmp[1] == location){
                return ++cnt;
            }
            else{
                // 프로세스 실행
                pri_queue.poll();
                cnt++;
            }
        }
        return cnt;
    }
}
