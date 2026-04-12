// PGM 118667 - 두 큐 합 같게 만들기
// 스택/큐
// https://school.programmers.co.kr/learn/courses/30/lessons/118667

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {

        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        int answer = 0;

        for(int i = 0; i < queue1.length; i++){
            q1.offer((long)queue1[i]);
            sum1 += queue1[i];
            q2.offer((long)queue2[i]);
            sum2 += queue2[i];
        }


        for(int i = 0; i < queue1.length * 3; i++){
            if(sum1 == sum2){
                return answer;

            }else if(sum1 > sum2){
                long temp = q1.poll();
                sum1 -= temp;
                sum2 += temp;
                q2.offer(temp);
                answer++;
            }else{
                long temp = q2.poll();
                sum2 -= temp;
                sum1 += temp;
                q1.offer(temp);
                answer++;
            }
        }
        return -1;
    }
}