// PGM 42586 - 기능개발
// 스택/큐
// https://school.programmers.co.kr/learn/courses/30/lessons/42586

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> q = new LinkedList<Integer>();
        int day = 0;
        int result = 1;

        // 첫 번째 기능이 완료될 때까지 시간 계산
        while(progresses[0] < 100){
            progresses[0] += speeds[0];
            day++;
        }

        for(int i = 1; i < progresses.length; i++){
            // 현재 기준으로도 완료되지 않은 경우
            if(progresses[i] + (speeds[i] * day) < 100){
                // 현재까지 진행된 만큼 반영
                progresses[i] += (speeds[i] * day);
                // 해당 기능이 완료될 때까지 추가 시간 계산
                while(progresses[i] < 100){
                    progresses[i] += speeds[i];
                    day++;
                }
                q.offer(result);
                result = 1;
            }else{
                result++;
            }
        }
        System.out.print(result);
        q.offer(result);

        int[] answer = new int[q.size()];
        int end = q.size();

        for(int i = 0; i<end; i++){
            answer[i] = q.poll();
        }

        return answer;
    }
}