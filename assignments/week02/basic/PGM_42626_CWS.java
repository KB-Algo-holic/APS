import java.util.*;

class Solution {
    public long solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        long l = scoville.length;
        long answer = -1;
        long cnt = 0;

        for(int i = 0; i < l; i++){
            pq.offer((long)scoville[i]);
        }

        while(l > 1){
            long num1 = pq.poll();
            long num2 = pq.poll();
            long num = num1 + (num2 * 2);
            pq.offer(num);
            cnt++;
            l--;

            long chk = pq.poll();
            if(chk >= K){
                answer = cnt;
                break;
            }else{
                pq.offer(chk);
            }
        }

        return answer;
    }
}