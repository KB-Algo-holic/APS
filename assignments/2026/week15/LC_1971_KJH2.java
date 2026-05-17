// [LC] 1971 Find if Path Exists in Graph 
// BFS
// leetcode.com/problems/find-if-path-exists-in-graph/
import java.util.*;
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);

        }
        que.offer(source);
        visited[source] = true;
        while(!que.isEmpty()){
            int chk = que.poll();
            if(chk == destination){
                return true;
            }
            for(int x : graph.get(chk)){
                if(visited[x] == false){
                    que.offer(x);
                    visited[x] = true;
                }
            }
        }
        return false;
    }
}
