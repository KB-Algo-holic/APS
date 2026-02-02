// PGM - 12938
// 구현 : AM–GM 부등식 (산술평균–기하평균 부등식) 곱의 최대 > 균등화의 원리
// https://school.programmers.co.kr/learn/courses/30/lessons/12938


import java.util.*;

class Solution {
    public int[] solution(int n, int s) {

        // 불가능 n개의 양의 정수 합의 최소는 n
        if (s < n) return new int[] { -1 };

        int[] answer = new int[n];

        int q = s / n;   // floor(mod)
        int r = s % n;   // remainder (0 <= r < n) -> q+1 횟수

        // 앞에는 q, 뒤 r개는 q+1
        for (int i = 0; i < n; i++) {
            answer[i] = (i < n - r) ? q : (q + 1);
        }

        return answer;
    }
}