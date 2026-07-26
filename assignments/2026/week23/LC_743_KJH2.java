// [LC] 743 Network Delay Time

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 999999);
        dist[k] = 0;

        for(int i = 1; i < n;i++){
            for(int[]  time : times){
                int u = time[0];
                int v = time[1];
                int w = time[2];
                if(dist[u] != 999999 && dist[u] + w < dist[v]){
                    dist[v]= dist[u] + w;
                }
            }
        }

        int maxTime = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == 999999){
                return -1;
            }
            else{
                if(maxTime < dist[i]){
                    maxTime = dist[i];
                }
            }
        }
        return maxTime;
    }
}
