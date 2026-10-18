import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        if(k >= enemy.length) return enemy.length;

        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int e : enemy) {
            pq.add(e);

            if(pq.size() > k) {
                n -= pq.poll();
            }

            if(n < 0) break;

            result++;
        }

        return result;
    }
}
