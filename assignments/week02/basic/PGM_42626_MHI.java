import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> que = new PriorityQueue<>((a,b) -> a-b);
        for (int num : scoville) {
            que.add(num);
        }

        int answer = 0;

        while (que.peek() < K) {
            if (que.size() < 2) return -1;

            int a = que.poll();
            int b = que.poll();

            que.add(a + b*2);
            answer++;
        }

        return answer;
    }
}