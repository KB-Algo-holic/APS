// PGM - 가장 먼 노드
// 그래프 및 BFS
//https://school.programmers.co.kr/learn/courses/30/lessons/49189

import java.util.*;

class Solution {
    // 그래프 구현
    public class Graph {
        // 변수 초기화 > 인접리스트, 방문, 거리 배열
        private Map<Integer, List<Integer>> adjList = new HashMap<>();
        private boolean[] visited;
        private int[] distance;

        // 클래스 초기화 > 정점 추가, 배열 생성
        public void init(int n) {
            for (int i=1; i<n+1; i++) {
                adjList.put(i, new ArrayList<>());
            }
            visited = new boolean[n+1];
            distance = new int[n+1];
        }

        // 간선 추가
        public void addEdge(int v1, int v2) {
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }

        // 그래프 출력
        // public void printGraph() {
        //     for (int v : adjList.keySet()) {
        //         System.out.println(v + " -> " + adjList.get(v));
        //     }
        // }

        // BFS 및 가장 먼 노드 개수 출력
        public int bfs(int start) {
            // 큐(덱) 초기화
            Queue<Integer> queue = new ArrayDeque<>();
            visited[start] = true;
            distance[start] = 0;
            queue.offer(start);

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int next: adjList.get(cur)) {
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    distance[next] = distance[cur] + 1;
                    queue.offer(next);
                }
            }

            // 가장 먼 노드의 거리 및 노드의 개수
            int maxDistance = 0;
            int maxDistanceCnt = 0;
            for (int dist: distance) {
                if (dist > maxDistance) {
                    maxDistance = dist;
                    maxDistanceCnt = 1;
                } else if (dist == maxDistance) {
                    maxDistanceCnt += 1;
                }
            }
            return maxDistanceCnt;
        }
    }

    public int solution(int n, int[][] edges) {
        int answer = 0;
        int[] visited = new int[n+1];
        Graph graph = new Graph();
        graph.init(n);

        for (int[] edge: edges) {
            graph.addEdge(edge[0], edge[1]);
        }

        return graph.bfs(1);
    }
}