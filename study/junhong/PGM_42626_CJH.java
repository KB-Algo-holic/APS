import java.util.*;

class Solution {
    int cnt = -1;
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        while(scoville != null) {
            scoville = doAction(scoville, K);
        }

        answer = cnt;
        return answer;
    }
    
    private int[] doAction(int[]scoville, int K) {
        Arrays.sort(scoville);
        
        if (scoville.length < 2) return null;
        if (scoville[0] >= K) return null;
        
        int[] newScoville = new int[scoville.length-1];
        newScoville[0] = scoville[0] + (scoville[1]*2);
        for (int i=1; i<newScoville.length; i++) {
            newScoville[i] = scoville[i+1];
        }
        
        cnt++;
        
        return newScoville;
    }
}

--------------------------------------------------------------------------

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville) {
            pq.add(i);
        }

        int i;
        while((i = pq.poll()) <= K) {
            pq.add(i + (pq.poll()*2));

            answer++;
        }

        return answer == 0 ? -1 : answer;
    }
}

--------------------------------------------------------------------------
    
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : scoville) {
            pq.add(i);
        }

        while(pq.peek() < K) {
            if (pq.size() == 1) return -1;
            pq.add(pq.poll() + (pq.poll()*2));

            answer++;
        }

        return answer;
    }
}
