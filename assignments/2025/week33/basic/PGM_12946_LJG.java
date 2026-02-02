// PGM 하노이의 탑
// 구현 - 재귀
// https://school.programmers.co.kr/learn/courses/30/lessons/12946?language=java


import java.util.*;

class Solution {

    List<int[]> moves = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);

        int[][] answer = new int[moves.size()][2];

        for (int i=0; i<moves.size(); i++) {
            answer[i] = moves.get(i);
        }

        return answer;
    }

    private void hanoi(int n, int from, int via, int to) {

        if (n == 1) {
            moves.add(new int[]{from, to});
            return;
        }

        hanoi(n-1, from, to, via);
        moves.add(new int[]{from, to});
        hanoi(n-1, via, from, to);
    }
}