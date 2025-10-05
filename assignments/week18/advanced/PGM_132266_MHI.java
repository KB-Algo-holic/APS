import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<Integer>[] tree = new ArrayList[n+1];
        for (int i=0; i<=n; i++) tree[i] = new ArrayList<Integer>();
        for (int i=0; i<roads.length; i++) {
            tree[roads[i][0]].add(roads[i][1]);
            tree[roads[i][1]].add(roads[i][0]);
        }

        Queue<int[]> que = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        for (int i=0; i<=n; i++) dist[i] = -1;

        que.add(new int[] {destination, 0});
        visited[destination] = true;

        while (!que.isEmpty()) {
            int node = que.peek()[0];
            int d = que.poll()[1];

            dist[node] = d;

            for (int next : tree[node]) {
                if (!visited[next]) {
                    que.add(new int[] {next, d+1});
                    visited[next] = true;
                }
            }
        }

        int[] answer = new int[sources.length];
        for (int i=0; i<sources.length; i++) {
            answer[i] = dist[sources[i]];
        }

        return answer;
    }
}