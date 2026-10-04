// PGM 142085 - 디펜스 게임
// 우선순위 큐
// https://school.programmers.co.kr/learn/courses/30/lessons/142085


import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = k;
        if(k > enemy.length){
            return enemy.length;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < k; i++){
            pq.offer(enemy[i]);
        }

        for(int i = k; i < enemy.length; i++){
            int prev = pq.poll();
            int next = enemy[i];
            int num = next;
            if(prev < next){
                num = prev;
                pq.offer(next);
            }else{
                pq.offer(prev);
            }
            if(n < num){
                break;
            }else{
                answer++;
                n -= num;
            }
        }

        return answer;
    }
}