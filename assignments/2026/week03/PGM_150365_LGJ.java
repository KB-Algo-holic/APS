// PGM - 미로탈출 명령어
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/150365

import java.util.*;

class Solution {
    // 이동 우선순위: d, l, r, u  (사전순: "d" < "l" < "r" < "u")
    static final char[] DIR = {'d', 'l', 'r', 'u'};
    static final int[] DX = { 1,  0,  0, -1};
    static final int[] DY = { 0, -1,  1,  0};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String ans = "impossible";
        // 불가능 조건 체크
        int startDist = Math.abs(x - r) + Math.abs(y - c);
        if (startDist > k) return ans;
        if (((k - startDist) & 1) == 1) return ans;

        StringBuilder sb = new StringBuilder();
        int cx = x, cy = y;

        for (int step = 0; step < k; step++) {
            int rem = k - step; // 현재 포함 남은 스텝 수

            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                // 격자 범위 체크 (1-indexed)
                if (nx < 1 || nx > n || ny < 1 || ny > m) continue;

                // 한 칸 이동 후 남은 스텝은 rem-1
                int dist = Math.abs(nx - r) + Math.abs(ny - c);
                int left = rem - 1;

                // 남은 스텝으로 도착 가능
                if (dist <= left && ((left - dist) & 1) == 0) {
                    sb.append(DIR[i]);
                    cx = nx;
                    cy = ny;
                    moved = true;
                    break;
                }
            }

            // 이론상 여기 오면 불가능
            if (!moved) return ans;
        }

        // k번 후에 정확히 도착했는지 최종 검증
        if (cx == r && cy == c) return sb.toString();
        return ans;
    }
}