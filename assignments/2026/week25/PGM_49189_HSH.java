package week25;
import java.util.*;
public class PGM_49189_HSH {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

        PGM_49189_HSH solution = new PGM_49189_HSH();
        int result = solution.solution(n, edge);

        System.out.println(result); // Output: 3
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;

        // 그래프를 인접 리스트로 표현
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // BFS를 사용하여 최단 거리 계산
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];

        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        // 최단 거리 중 가장 큰 값 찾기
        int maxDistance = Arrays.stream(distance).max().orElse(0);

        // 최단 거리가 가장 큰 노드의 개수 세기
        for (int dist : distance) {
            if (dist == maxDistance) {
                answer++;
            }
        }

        return answer;
    }
}
