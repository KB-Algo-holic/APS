import java.util.*;

// PGM - 118669 L3_등산코스정하기
// 그래프
// https://school.programmers.co.kr/learn/courses/30/lessons/118669
public class PGM_118669_YHS {
    List[] graph;
    boolean isVisited[];
    Set<Integer> start, end;
    PriorityQueue<Node> pq;
    int intensity = Integer.MAX_VALUE;
    int no = Integer.MAX_VALUE;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        graph = new List[n+1];
        isVisited = new boolean[n+1];
        start = new HashSet<>();
        end = new HashSet<>();

        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<Node>();
        }

        for(int i=0; i<paths.length; i++){
            int from = paths[i][0];
            int to = paths[i][1];
            int val = paths[i][2];
            graph[from].add(new Node(to, val));
            graph[to].add(new Node(from, val));
        }

        for(int i=0; i<gates.length; i++){
            start.add(gates[i]);
        }

        for(int i=0; i<summits.length; i++){
            end.add(summits[i]);
        }

        pq = new PriorityQueue<>();
        for(int i=0; i<gates.length; i++){
            pq.offer(new Node(gates[i], 0));
        }

        dijkstra();

        answer[0] = no;
        answer[1] = intensity;

        return answer;
    }

    void dijkstra(){
        while(!pq.isEmpty()){
            Node front = pq.poll();
            // System.out.println(front.n+" : "+front.v);
            isVisited[front.n] = true;

            if(front.v > intensity){
                break;
            }

            if(end.contains(front.n)){
                // System.out.println(">>>"+front.n+" : "+front.v);
                if(intensity >= front.v){
                    intensity = front.v;

                    if(no > front.n){
                        no = front.n;
                    }
                }
                continue;
            }

            List<Node> childs = graph[front.n];
            for(int i=0; i<childs.size(); i++){
                Node child = childs.get(i);
                if(!isVisited[child.n] && !start.contains(child.n)){
                    pq.offer(new Node(child.n, Integer.max(front.v, child.v)));
                }
            }
        }
    }

    class Node implements Comparable<Node>{
        int n;
        int v;

        public Node(int n, int v) {
            this.n = n;
            this.v = v;
        }

        @Override
        public int compareTo(Node o){
            if(this.v == o.v){
                return Integer.compare(this.n, o.n);
            }
            return Integer.compare(this.v, o.v);
        }
    }
}
