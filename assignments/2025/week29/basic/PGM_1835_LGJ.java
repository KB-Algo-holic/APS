// PGM - 1835
// DFS 백트랙킹
// https://school.programmers.co.kr/learn/courses/30/lessons/1835

import java.util.*;

class Solution {
    private static final char[] FRIENDS = {'A','C','F','J','M','N','R','T'};

    private String[] data;
    private int answer;

    // pos[c] = 줄에서의 위치 (0~7), 아직 배치 안 됐으면 -1
    private int[] pos = new int[128]; // ASCII
    private boolean[] used = new boolean[8];

    public int solution(int n, String[] data) {
        this.data = data;
        this.answer = 0;

        Arrays.fill(pos, -1);
        Arrays.fill(used, false);

        dfs(0);
        return answer;
    }

    private void dfs(int idx) {
        // 8명 다 배치 완료
        if (idx == 8) {
            answer++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (used[i]) continue;

            char cur = FRIENDS[i];
            used[i] = true;
            pos[cur] = idx;

            if (isValid()) {
                dfs(idx + 1);
            }

            // 복구
            pos[cur] = -1;
            used[i] = false;
        }
    }

    private boolean isValid() {
        for (String rule : data) {
            char a = rule.charAt(0);
            char b = rule.charAt(2);
            char op = rule.charAt(3);
            int d = rule.charAt(4) - '0';

            int pa = pos[a];
            int pb = pos[b];

            // 둘 중 하나라도 아직 배치 안 됐으면 지금은 판단 불가 -> 통과
            if (pa == -1 || pb == -1) continue;

            int gap = Math.abs(pa - pb) - 1; // 사이에 있는 사람 수

            if (op == '=') {
                if (gap != d) return false;
            } else if (op == '<') {
                if (!(gap < d)) return false;
            } else if (op == '>') {
                if (!(gap > d)) return false;
            }
        }
        return true;
    }
}