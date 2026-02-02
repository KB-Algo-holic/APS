// PGM 12946 - 하노이의 탑
// 재귀
// https://school.programmers.co.kr/learn/courses/30/lessons/12946

import java.util.*;

class Solution {
    List<int[]> arr = new ArrayList<>();

    void move(int cnt, int start, int mid, int end) {
        if (cnt == 0) {
            return;
        }
        move(cnt - 1, start, end, mid);
        arr.add(new int[]{start, end});
        move(cnt - 1, mid, start, end);
    }

    public int[][] solution(int n) {
        move(n, 1, 2, 3);

        return arr.stream().toArray(int[][]::new);
    }
}