// PGM 12946 - 하노이의 탑
// 재귀
// https://school.programmers.co.kr/learn/courses/30/lessons/12946

import java.util.*;

class Solution {
    List<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {
        move(n, 1, 3, 2);

        int[][] answer = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private void move(int n, int start, int end, int mid) {
        if (n == 1) {
            list.add(new int[]{start, end});
            return;
        }

        move(n - 1, start, mid, end);
        list.add(new int[]{start, end});
        move(n - 1, mid, end, start);
    }
}