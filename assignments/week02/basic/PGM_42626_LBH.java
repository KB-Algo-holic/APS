import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int s : scoville) {
            heap.offer(s);
        }

        while (heap.size() > 1) {
            if (heap.peek() >= K) {
                break;
            }

            int first = heap.poll();
            int second = heap.poll();
            int newScoville = first + (second * 2);

            heap.offer(newScoville);

            answer++;
        }

        if (heap.peek() < K) {
            return -1;
        }

        return answer;
    }
}