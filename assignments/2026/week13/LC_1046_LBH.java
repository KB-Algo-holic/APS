// Last Stone Weight
// 우선순위 큐
// https://leetcode.com/problems/last-stone-weight/

import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones) {
            pq.offer(stone);
        }

        while(pq.size() >= 2) {
            int y = pq.poll();
            int x = pq.poll();

            if(y != x) {
                pq.offer(y - x);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}