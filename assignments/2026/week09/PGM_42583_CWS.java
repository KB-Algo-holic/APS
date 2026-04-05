// PGM 42583 - 다리를 지나는 트럭
// 스택/큐
// https://school.programmers.co.kr/learn/courses/30/lessons/42583


import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weight) {

        int time = 0;
        int num = 0;
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();

        // 초기 다리는 길이만큼 0으로 채움 (빈 공간)
        for(int i = 0; i < bridge_length; i++){
            q.offer(0);
        }

        // 모든 트럭이 다 건널 때까지 반복
        while(cnt < truck_weight.length){
            time++;
            int n = q.poll();

            // 트럭이 빠진 경우
            if(n != 0){
                weight += n;
                cnt++;
            }
            // 다음 트럭을 올릴 수 있는 경우
            if(num < truck_weight.length && weight >= truck_weight[num]){
                weight -= truck_weight[num];
                q.offer(truck_weight[num++]);
            }else{
                q.offer(0);
            }
        }


        return time;
    }
}