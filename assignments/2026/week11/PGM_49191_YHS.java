// PGM - 49191 L3_순위
// 그래프
// https://school.programmers.co.kr/learn/courses/30/lessons/49191
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PGM_49191_YHS {
    List[] graph;
    List[] graph2;
    boolean[] isVisited;
    public int solution(int n, int[][] results) {
        int answer = 0;

        graph = new List[n+1];
        graph2 = new List[n+1];

        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<Integer>();
            graph2[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<results.length; i++){
            int from = results[i][0];
            int to   = results[i][1];

            graph[from].add(to);
            graph2[to].add(from);
        }

        for(int i=1; i<n+1; i++){
            isVisited = new boolean[n+1];
            int a = bfs(i, graph);
            isVisited = new boolean[n+1];
            int b = bfs(i, graph2);
            if(a+b-1 == n){
                answer++;
            }
        }

        return answer;
    }

    private int bfs(int start, List<Integer> graph[]){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        isVisited[start] = true;
        int cnt = 0;

        while(!queue.isEmpty()){
            cnt++;
            int front = queue.poll();
            List<Integer> childs = graph[front];
            for(int i=0; i<childs.size(); i++){
                int child = childs.get(i);
                if(!isVisited[child]){
                    isVisited[child] = true;
                    queue.offer(child);
                }
            }
        }
        return cnt;
    }
}
