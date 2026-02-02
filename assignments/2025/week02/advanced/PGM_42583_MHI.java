import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> que = new LinkedList<>();
        int totalW = 0;
        int i = 0;
        int answer = 0;

        while (true) {
            answer ++;

            if (que.size() == bridge_length) {
                int truck = que.poll();
                totalW -= truck;

                if (i == truck_weights.length && totalW == 0) break;
            }

            if (i < truck_weights.length && totalW + truck_weights[i] <= weight) {
                totalW += truck_weights[i];
                que.offer(truck_weights[i]);
                i ++;
                continue;
            }

            que.offer(0);
        }

        return answer;
    }
}