// PGM 12938 - 최고의 집합
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12938

import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        int quot, rem;
        quot = (int)(s / n);
        rem = s % n;

        if(quot == 0) {
            return new int[]{-1};
        }

        for(int i = 0; i < n; i++) {
            if(i < rem) {
                answer[i] = quot + 1;
            } else {
                answer[i] = quot;
            }
        }

        Arrays.sort(answer);

        return answer;
    }
}