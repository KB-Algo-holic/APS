// LC - 1971 Find if Path Exists in Graph
// BFS
// https://leetcode.com/problems/find-if-path-exists-in-graph/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_1971_YHS {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean answer = false;
        boolean[] isVisited = new boolean[n];
        List graph[] = new List[n];

        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];

            graph[from].add(to);
            graph[to].add(from);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        isVisited[source] = true;

        while(!queue.isEmpty()){
            int front = queue.poll();
            if(front == destination){
                answer = true;
            }

            List<Integer> childs = graph[front];
            for(int i=0; i<childs.size(); i++){
                int child = childs.get(i);
                if(!isVisited[child]){
                    isVisited[child] = true;
                    queue.offer(child);
                }
            }
        }

        return answer;
    }
}
