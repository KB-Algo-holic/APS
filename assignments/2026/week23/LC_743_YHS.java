// LC - 743 Network Delay Time
// Dijkstra
// https://leetcode.com/problems/network-delay-time/description/
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC_743_YHS {
    int[] distance;
    List<Node>[] graph;
    public int networkDelayTime(int[][] times, int n, int k) {
        distance = new int[n+1];
        graph = new List[n+1];

        for(int i=1; i<n+1; i++){
            distance[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<times.length; i++){
            int from = times[i][0];
            int to = times[i][1];
            int val = times[i][2];

            graph[from].add(new Node(to, val));
        }

        distance[k] = 0;

        dijkstra(k);


        int max = 0;
        for(int i=0; i<n+1; i++){
            max = Math.max(max, distance[i]);
        }

        if(max == Integer.MAX_VALUE){
            return -1;
        }

        return max;
    }

    void dijkstra(int k){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k, 0));

        while(!pq.isEmpty()){
            Node front = pq.poll();
            List<Node> childs = graph[front.node];

            for(int i=0; i<childs.size(); i++){
                Node child = childs.get(i);

                if(distance[child.node] > distance[front.node] + child.val){
                    distance[child.node] = distance[front.node] + child.val;
                    pq.offer(child);
                }
            }
        }

    }

    class Node implements Comparable<Node>{
        int node;
        int val;

        public Node(int node, int val){
            this.node = node;
            this.val = val;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.val, o.val);
        }
    }
}
