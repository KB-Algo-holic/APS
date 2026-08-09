// PGM - 49189 가장 먼 노드
// BFS (그래프)
// https://school.programmers.co.kr/learn/courses/30/lessons/49189


import java.util.*;

class Solution {

    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};

    public int solution(int n, int[][] edge) {
        int answer = 0;


        List<Integer>[] graph = new ArrayList[n+1];
        for (int i=0; i<=n; i++) graph[i] = new ArrayList<>();

        for (int[] e: edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {1, 0});
        distance[1] = 0;
        int maxCnt = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll(); // node, cnt
            int cur_node = cur[0];
            int cnt = cur[1];

            if (cnt > maxCnt) maxCnt = cnt;

            // next
            for (int next: graph[cur_node]) {

                if (distance[next] != -1) continue;
                distance[next] = cnt + 1;
                q.offer(new int[] {next, cnt+1});
            }

        }

        for (int dist: distance) {
            if (dist == maxCnt) answer ++;
        }

        return answer;
    }
}