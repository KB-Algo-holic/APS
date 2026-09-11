// PGM 42885 구명보트
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/42885


import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int total = 0;
        Arrays.sort(people);
        Deque<Integer> deque = new ArrayDeque<>();

        for (int p: people) {
            deque.offer(p);
        }
        //System.out.println(deque);
        while (!deque.isEmpty()) {
            Integer min = deque.peekFirst();
            Integer max = deque.pollLast();

            if (min+max <= limit) {
                deque.pollFirst();
            }

            answer ++;


        }

        return answer;
    }
}
