// PGM 42626 - 더 맵게
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42626?language=java

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int a : scoville){
            pq.add(a);
        }
        
        int min = pq.peek();
        
        while (min < K){
            
            if(pq.size() >= 2){
                pq.add(pq.poll() + (pq.poll() * 2));
                min = pq.peek();
                answer++;
            }else{
                return -1;
            }
        }
        return answer;
    }
}
