// PGM - 132266 부대복귀
// BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/132266
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PGM_132266_YHS {
    int[] distance;
    List<Integer>[] graph;
    boolean[] isVisited;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        distance = new int [n+1];
        graph = new List[n+1];
        isVisited = new boolean[n+1];

        for(int i=0; i<n+1; i++){
            distance[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<roads.length; i++){
            int from = roads[i][0];
            int to = roads[i][1];

            graph[from].add(to);
            graph[to].add(from);
        }

        dijkstra(destination);

        // System.out.println(Arrays.toString(distance));

        for(int i=0; i<sources.length; i++){
            int source = sources[i];
            if(distance[source] == Integer.MAX_VALUE){
                answer[i] = -1;
            }else{
                answer[i] = distance[source];
            }
        }

        return answer;
    }

    void dijkstra(int start){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        isVisited[start] = true;
        distance[start] = 0;

        while(!queue.isEmpty()){
            int[] front = queue.poll();
            distance[front[0]] = front[1];
            List<Integer> childs = graph[front[0]];

            for(int i=0; i<childs.size(); i++){
                int child = childs.get(i);

                if(!isVisited[child]){
                    queue.offer(new int[]{child, front[1]+1});
                    isVisited[child] = true;
                }
            }

        }
    }
}
