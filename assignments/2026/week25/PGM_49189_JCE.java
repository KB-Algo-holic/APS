/* 
 * PGM 49189 - 가장 먼 노드
 * https://school.programmers.co.kr/learn/courses/30/lessons/49189

import java.util.*;
class Solution {
    public static int solution(int n, int[][] edge) {
        int answer = 0;

        // 1. 인접리스트 구성
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        // 2. bfs 돌면서 1부터 각 노드까지의 최단거리
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        dist[1] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int gNode : graph[node]) {
                // 아직 방문하지 않은 인접 노드
                if (dist[gNode] == -1) {
                    dist[gNode] = dist[node] + 1;
                    queue.offer(gNode);
                }
            }
        }

        // 3. 최단거리가 1에서부터의 거리가 가장 먼 값인 노드의 개수 구하기
        int maxDist = 0;
        for (int d : dist) {
            maxDist = Math.max(maxDist, d);
        }

        for (int d : dist) {
            if (d == maxDist) answer++;
        }

        return answer;
    }

}
