// PGM 42583 - 다리를 지나는 트럭
// 유형: 큐
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42583

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;

        Queue<Integer> bridgeQueue = new LinkedList<>();
        int bridgeWeight = 0;
        int truckIndex = 0;

        while(true) {
            time++;

            if(bridgeQueue.size() == bridge_length) {
                bridgeWeight -= bridgeQueue.poll();
            }

            if (truckIndex == truck_weights.length) {
                if (bridgeQueue.isEmpty() || bridgeWeight == 0) {
                    break;
                } else {
                    bridgeQueue.add(0);
                }
            } else {
                if(bridgeWeight + truck_weights[truckIndex] <= weight){
                    bridgeWeight += truck_weights[truckIndex];
                    bridgeQueue.add(truck_weights[truckIndex++]);
                } else {
                    bridgeQueue.add(0);
                }
            }
        }

        return time;
    }
}