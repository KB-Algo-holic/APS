// PGM 42861 - 섬연결하기
// 유형: 그리디
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42861

import java.util.*;
class Solution {
    public int solution(int n, int[][] edges) {
        int answer = 0;
        // 변수 초기화
        // vistied
        boolean[] visited = new boolean[n];
        // 그래프 초기화
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            int cost = edge[2];

            graph[node1].add(new int[]{node2, cost});
            graph[node2].add(new int[]{node1, cost});

        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0}); // 0번째 노드 시작
        int count = 0;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int node = temp[0];
            int cost = temp[1];

            if (visited[node]) {continue;}
            visited[node] = true;
            answer += cost;
            count++;
            if (count == n) { break; }

            for (int[] edge : graph[node]) {
                int node2 = edge[0];
                int cost2 = edge[1];
                if (!visited[node2]) {
                    pq.add(new int[]{node2, cost2});
                }
            }
        }

        return answer;
    }
}