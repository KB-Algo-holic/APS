// PGM 132266 - 부대복귀
// 최단경로
// https://school.programmers.co.kr/learn/courses/30/lessons/132266

import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        for (int[] r : roads) {
            list.get(r[0]).add(r[1]);
            list.get(r[1]).add(r[0]);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[destination] = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(destination);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : list.get(cur)) {
                if (dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) answer[i] = dist[sources[i]];
        return answer;
    }
}