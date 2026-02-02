import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);

        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i=0; i<=n; i++) list[i] = new ArrayList<>();
        for(int i=0; i<edge.length; i++) {
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        dist[1]=0;

        int max = 0;
        int ans = 0;
        while(!que.isEmpty()){
            int now = que.poll();
            for(int next : list[now]) {
                if(dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    if (dist[next] > max) {
                        max = dist[next];
                        ans = 1;
                    } else if (dist[next] == max) {
                        ans ++;
                    }
                    que.add(next);
                }
            }
        }
        return ans;
    }
}