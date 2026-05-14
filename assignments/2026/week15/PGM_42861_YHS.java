// PGM - 42861 L3_섬연결하기
// BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/42861
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PGM_42861_YHS {
    List[] graph;
    boolean[] isVisited;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        graph = new List[n];
        isVisited = new boolean[n];

        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<Node>();
        }

        for(int i=0; i<costs.length; i++){
            int from = costs[i][0];
            int to = costs[i][1];
            int val = costs[i][2];

            graph[from].add(new Node(to, val));
            graph[to].add(new Node(from, val));
        }

        answer = solve(0);

        return answer;
    }

    int solve(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        int sum = 0;

        while(!pq.isEmpty()){
            Node front = pq.poll();
            if(isVisited[front.n]) continue;

            isVisited[front.n] = true;
            sum += front.val;
            List<Node> childs = graph[front.n];
            for(int i=0; i<childs.size(); i++){
                Node child = childs.get(i);
                if(!isVisited[child.n]){
                    pq.offer(child);
                }
            }
        }

        return sum;
    }

    class Node implements Comparable<Node>{
        int n;
        int val;

        public Node(int n, int val){
            this.n = n;
            this.val = val;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.val, o.val);
        }
    }
}
