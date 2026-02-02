// PGM - 배달
// 그래프 및 다익스트라
// https://school.programmers.co.kr/learn/courses/30/lessons/12978



import java.util.*;

class Solution {
    int[] result = new int[51];

    public int solution(int N, int[][] road, int K) {
        Arrays.fill(result, Integer.MAX_VALUE);
        result[1] = 0;

        // 인접 리스트 생성
        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int[] r : road) {
            int a = r[0], b = r[1], c = r[2];
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        dijkstra(N, graph);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (result[i] <= K) answer++;
        }
        return answer;
    }

    void dijkstra(int N, List<int[]>[] graph) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];

            if (cost > result[node]) continue;

            for (int[] next : graph[node]) {
                int nxtNode = next[0];
                int nxtCost = next[1];
                if (result[nxtNode] > cost + nxtCost) {
                    result[nxtNode] = cost + nxtCost;
                    pq.offer(new int[]{nxtNode, cost + nxtCost});
                }
            }
        }
    }
}
