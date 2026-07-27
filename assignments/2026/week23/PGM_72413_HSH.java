package week23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PGM_72413_HSH {

    static final int INF = 100_000_000;

    static class Node implements Comparable<Node> {
        int target;
        int cost;

        Node(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static ArrayList<Node>[] graph;

    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;

        int[][] fares = {
                { 4, 1, 10 },
                { 3, 5, 24 },
                { 5, 6, 2 },
                { 3, 1, 41 },
                { 5, 1, 24 },
                { 4, 6, 50 },
                { 2, 4, 66 },
                { 2, 3, 22 },
                { 1, 6, 25 }
        };

        int result = solution(n, s, a, b, fares);

        System.out.println(result); // 82
    }

    public static int solution(
            int n,
            int s,
            int a,
            int b,
            int[][] fares) {
        // 그래프 배열은 간선 개수가 아니라 정점 개수만큼 생성
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 양방향 간선 연결
        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];

            addEdge(from, to, cost);
        }

        // 세 지점에서 다익스트라 실행
        int[] distanceS = dijkstra(n, s);
        int[] distanceA = dijkstra(n, a);
        int[] distanceB = dijkstra(n, b);

        int answer = INF;

        // k: 합승을 종료하고 각자 갈라지는 지점
        for (int k = 1; k <= n; k++) {
            int totalCost = distanceS[k]
                    + distanceA[k]
                    + distanceB[k];

            answer = Math.min(answer, totalCost);
        }

        return answer;
    }

    public static void addEdge(int from, int to, int cost) {
        graph[from].add(new Node(to, cost));
        graph[to].add(new Node(from, cost));
    }

    public static int[] dijkstra(int n, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            int currentTarget = current.target;
            int currentCost = current.cost;

            // 이미 더 짧은 경로가 등록된 경우 무시
            if (currentCost > dist[currentTarget]) {
                continue;
            }

            for (Node next : graph[currentTarget]) {
                int nextCost = currentCost + next.cost;

                if (nextCost < dist[next.target]) {
                    dist[next.target] = nextCost;
                    pq.offer(new Node(next.target, nextCost));
                }
            }
        }

        return dist;
    }
}