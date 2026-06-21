// 숫자의 표현
// 투포인터/슬라이딩 윈도우
// https://school.programmers.co.kr/learn/courses/30/lessons/12924

import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        int prefixSum = 0;

        for(int i = 1; i <= n; i++){
            if(i == n){
                answer++;
                break;
            }

            if(i <= n / 2 + 1){
                prefixSum += i;
                queue.add(i);

                while(prefixSum > n){
                    int front = queue.poll();
                    prefixSum -= front;
                }

                if(prefixSum == n){
                    answer++;
                }
            }
        }

        return answer;
    }
}