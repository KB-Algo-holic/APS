// PGM 132266 부대복귀
// BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/132266
// 역방향..

import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 1. 인접 리스트 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        // 2. destination에서 시작하는 최단 거리 배열 초기화
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        // 3. 역방향 BFS 딱 1번만 수행
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(destination);
        dist[destination] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                // 아직 방문하지 않은 노드라면 최단 거리 갱신
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }

        // 4. sources에 대한 결과 매핑
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }

        return answer;
    }
}