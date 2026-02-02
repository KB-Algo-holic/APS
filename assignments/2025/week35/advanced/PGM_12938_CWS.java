// PGM 12938 - 최고의 집합
// 유형: 시뮬레이션
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12938

import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        //   s < n이면 자연수 n개로 만들 수 없음
        if(n > s){
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        int[] answer = new int[n];

        int m = n; // 남은 개수

        for(int i = 0; i < n; i++){

            // 현재 남은 합 s를 남은 개수 m으로 나눈 몫을 넣음
            answer[i] = s / m;

            // 나머지가 있으면 1 더해줌
            if(i == n - 1 && s % m != 0)
                answer[i] += 1;

            // 방금 넣은 값을 s에서 빼고
            s -= s / m;
            // 남은 개수 감소
            m--;
        }

        return answer;
    }
}
