// PGM 468377 힌트 스테이지
// DFS
// https://school.programmers.co.kr/learn/courses/30/lessons/468377


import java.util.*;

class Solution {

    int answer = Integer.MAX_VALUE;
    int n;
    int[][] costs;
    int[][] hints;
    public int solution(int[][] cost, int[][] hint) {
        // 구매 하냐 안하냐 이지선다
        // 기준 : 얻을 수 있는 힌트로 파훼하기 vs 없이 파훼하기
        // 완전탐색
        n = cost.length;
        costs = cost;
        hints = hint;

        dfs(0, new boolean[n-1]);
        return answer;
    }

    private void dfs(int idx, boolean[] cur) {

        if (idx == n-1) {
            //System.out.println(Arrays.toString(cur));
            int total = play(costs, hints, cur);
            //System.out.println(total);
            if (answer > total) {
                answer = total;
            }
            return ;
        }


        cur[idx] = true;
        dfs(idx+1, cur);
        cur[idx] = false;
        dfs(idx+1, cur);
    }

    private int play(int[][] costs, int[][] hints, boolean[] isBought) {
        int total = 0;
        int[] bunddle = new int[n+1]; //스테이징 별 힌트
        // 번들 초기화
        for (int i=0; i<n-1; i++) {
            if (isBought[i]) {
                int[] h = hints[i];
                total += h[0];
                for (int j=1; j<h.length; j++) {
                    int stage = h[j];
                    bunddle[stage] += 1;
                }
            }
        }

        for (int i=0; i<n; i++) {
            int[] c = costs[i];
            int cnt = bunddle[i+1];
            if (cnt >= c.length) {
                total += c[c.length-1];
            } else {
                total += c[cnt];
            }

        }

        return total;

    }


}