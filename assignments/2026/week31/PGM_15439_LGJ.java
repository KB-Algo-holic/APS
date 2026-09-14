// PGM 154539 뒤에 있는 큰 수
// 스택
// https://school.programmers.co.kr/learn/courses/30/lessons/154539

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];

        Deque<int[]> deque = new ArrayDeque<>();

        for (int i=0; i<n; i++) {
            int num = numbers[i];

            while (!deque.isEmpty() && deque.peek()[1] < num) {
                int[] top = deque.pop();
                answer[top[0]] = num;
            }

            deque.push(new int[] {i, num});
        }

        while (!deque.isEmpty()) {
            int[] top = deque.pop();
            answer[top[0]] = -1;
        }



        return answer;
    }
}