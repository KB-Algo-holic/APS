package week30;
import java.util.*;
public class PGM_132266_HSH {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PGM_132266_HSH sol = new PGM_132266_HSH();
        int n = 5;
        int[][] roads = {{1, 2}, {1, 3}, {2, 4}, {3, 4}, {4, 5}};
        int[] sources = {1, 2, 3};
        int destination = 5;
        int[] result = sol.solution(n, roads, sources, destination);
        System.out.println(result);
    }

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];

            graph[a].add(b);
            graph[b].add(a);
        }
        // 거리 배열
        int[] distance = new int[n + 1];
        // 방문하지 않은 곳은 -1로 채울것
        Arrays.fill(distance, -1);
        // 목적지에서 큐작업
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(destination);
        distance[destination] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {

                // 이미 방문했으면 넘어감
                if (distance[next] != -1) {
                    continue;
                }
                // 다음 갈 곳은 현재 거리에 + 1
                distance[next] = distance[current] + 1;
                queue.offer(next);
            }
        }
        // source들의 거리만 가져오기
        int[] answer = new int[sources.length];

        for (int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }
        return answer;
    }
}