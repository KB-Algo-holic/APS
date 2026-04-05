// 가장 큰 수
// 정렬
// https://school.programmers.co.kr/learn/courses/30/lessons/42746

import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        Integer[] answer = Arrays.stream(numlist).boxed().toArray(Integer[]::new);

        Arrays.sort(answer, (a, b) -> {
            if(Math.abs(n - a) == Math.abs(n - b)) {
                return b - a;
            }

            return Math.abs(n - a) - Math.abs(n - b);
        });

        return Arrays.stream(answer).mapToInt(Integer::intValue).toArray();
    }
}