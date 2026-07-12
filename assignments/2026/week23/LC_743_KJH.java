// LC 743 - network-delay-time
// 구현
// https://leetcode.com/problems/network-delay-time/

import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currNode = current[0];
            int currWeight = current[1];

            if (currWeight > dist[currNode]) continue;

            for (int[] edge : graph.get(currNode)) {
                int nextNode = edge[0];
                int weight = edge[1];

                if (dist[currNode] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[currNode] + weight;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // 도달할 수 없는 노드가 있는 경우
            }
            maxDelay = Math.max(maxDelay, dist[i]);
        }

        return maxDelay;
    }
}
