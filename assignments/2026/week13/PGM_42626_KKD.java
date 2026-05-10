
// PGM 42626 - 더 맵게
// 힙
// https://school.programmers.co.kr/learn/courses/30/lessons/42626
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for(int i=0;i<scoville.length;i++)
        {
            pQ.add(scoville[i]);
        }
        
        while(pQ.peek() < K)
        {
            //System.out.println(pQ.peek());
            if(pQ.size()<2)
            {
                answer = -1;
                break;
            }
                
            
            int item = pQ.poll();
            int item2 = pQ.poll();

            pQ.add(item+item2*2);
            answer++;
        }
        
        return answer;
    }
}
