import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int sc : scoville) {
            pq.offer(sc);
        }
        
        while(pq.peek() < K) {
            
            if (pq.size() < 2) {
                return -1;
            }
            int a = pq.poll();
            int b = pq.poll();
            int ns = a + (b * 2);
            pq.offer(ns);
            answer++;
        }
        
        return answer;
    }
}
