class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<int[]>> inv = new ArrayList<>();

        for(int i = 0; i < n+1; i++){
            inv.add(new ArrayList<>());
        }
        for(int i = 0; i < times.length; i++){
            inv.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }
        int[] dist = new int[n+1];
        for(int i = 1; i < n+1; i++){
            dist[i] = 10000;
        }

        dist[k] = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);

        q.offer(new int[]{k, 0});

        while (!q.isEmpty()){
            int[] now = q.poll();
            if(dist[now[0]] < now[1]){
                continue;
            }
            for(int i = 0; i < inv.get(now[0]).size(); i++){
                int[] adj = inv.get(now[0]).get(i);
                if(dist[adj[0]] > now[1] + adj[1]){
                    dist[adj[0]] = now[1] + adj[1];
                    q.offer(new int[]{adj[0], dist[adj[0]]});
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n+1; i++){
            if (dist[i] == 10000){
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        
        return ans;
    }
}
