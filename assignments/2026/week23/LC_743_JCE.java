class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < times.length; i++){
            graph.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }
        int[] dist = new int[n+1];
        for(int i = 1; i < n+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[]{k, 0});
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            if(dist[cur[0]] < cur[1]){
                continue;
            }
            for(int i = 0; i < graph.get(cur[0]).size(); i++){
                int[] adj = graph.get(cur[0]).get(i);
                if(dist[adj[0]] > cur[1] + adj[1]){
                    dist[adj[0]] = cur[1] + adj[1];
                    pq.offer(new int[]{adj[0], dist[adj[0]]});
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n+1; i++){
            if (dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        
        return ans;
    }
}
