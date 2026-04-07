// PGM 118667 - 두 큐 합 같게 만들기
// 유형: 스택
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/118667

import java.util.ArrayDeque;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int size = queue1.length + queue2.length;
        
        ArrayDeque<Integer> deque1 = new ArrayDeque<>();
        ArrayDeque<Integer> deque2 = new ArrayDeque<>();
        
        long sum1 = 0;
        for (int num : queue1) {
            deque1.add(num);
            sum1 += num;
        }
        long sum2 = 0;
        for (int num : queue2) {
            deque2.add(num);
            sum2 += num;
        }
        
        if ((sum1 + sum2)%2 == 1) return -1;
        
        while (true) {
            if (sum1 == sum2) return answer;
            
            if (answer > size*2) return -1;
            
            if (sum1 > sum2) {
                int num = deque1.poll();
                sum1 -= num;
                deque2.offer(num);
                sum2 += num;
            }
            
            else if (sum2 > sum1) {
                int num = deque2.poll();
                sum2 -= num;
                deque1.offer(num);
                sum1 += num;
            }
            
            answer += 1;
        }
    }
}