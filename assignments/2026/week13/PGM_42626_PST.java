// PGM 42626 - 더 맵게
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42626

import java.util.PriorityQueue;

public class PGM_42626_PST {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            PriorityQueue<Integer> queue = new PriorityQueue<>();

            for (int s : scoville) {
                queue.add(s);
            }

            while (!queue.isEmpty() && queue.peek() < K) {
                if (queue.size() < 2) {
                    return -1;
                }
                int first = queue.poll();
                int second = queue.poll();

                int mixed = first + (second * 2);

                queue.add(mixed);
                answer++;
            }
            return answer;
        }
    }
}
