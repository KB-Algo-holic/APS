import java.util.Collections;
import java.util.PriorityQueue;

// LC - 1046 Last Stone Weight
// 우선순위큐
// https://leetcode.com/problems/last-stone-weight/description/
public class LC_1046_YHS {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<stones.length; i++){
            pq.offer(stones[i]);
        }

        while(pq.size()>1){
            int first  = pq.poll();
            int second = pq.poll();

            if(first != second){
                pq.offer(first-second);
            }
        }

        if(pq.size() == 1){
            return pq.poll();
        }else{
            return 0;
        }
    }
}
