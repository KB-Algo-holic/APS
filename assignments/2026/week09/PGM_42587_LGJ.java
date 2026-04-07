// PGM - 42587 프로세스
// 큐
// https://school.programmers.co.kr/learn/courses/30/lessons/42587

import java.util.*;

class Solution {
    public static int solution(int[] priorities, int location) {
        int count = 0;
        int n = priorities.length;
        int front = 0;

        boolean[] deleted = new boolean[n];

        while (!deleted[location]) { // location 삭제될 때 까지
            if (!deleted[front]) { //꺼낸 프로세스가 삭제되지 않은 경우만
                // 우선순위가 가장 높은 프로세스일 때만 삭제처리
                if (isMax(priorities, front, deleted)) {
                    count ++;
                    deleted[front] = true;
                }
            }
            // 다음 항목 탐색을 위한 초기화
            front ++;
            if (front >= n) front %= n;
        }

        return count;
    }

    static boolean isMax(int[] priorities, int cur, boolean[] deleted) {

        for (int i=0; i<priorities.length; i++) {
            if (cur == i) continue;
            if (priorities[i] > priorities[cur] && !deleted[i]) return false;
        }

        return true;
    }

}