// BOJ 1753 - 최단경로
// 유형: 리스트
// 링크: https://www.acmicpc.net/problem/1753
// *List<List<Node>> 구현방법 AI 도웅을 받음

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 인접 리스트 (그래프)
    static List<List<Node>> list; //2차원 배열로 구할경우 터지므로 리스트를 사용햐여함

    // 시작점으로부터의 최단 거리 배열
    static int[] dist;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점 개수
        int E = Integer.parseInt(st.nextToken()); // 간선 개수
        int start = Integer.parseInt(br.readLine()); // 시작 정점

        // 거리 배열 초기화
        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 인접 리스트 초기화
        list = new ArrayList<>();
        for(int i = 0; i <= V; i++){
            list.add(new ArrayList<>());
        }

        // 간선 입력
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken()); // 출발
            int p2 = Integer.parseInt(st.nextToken()); // 도착
            int p3 = Integer.parseInt(st.nextToken()); // 가중치
            list.get(p1).add(new Node(p2, p3));
        }

        // 다익스트라 실행
        di(start);

        // 결과 출력
        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
    }

    // 다익스트라 알고리즘
    public static void di(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작점 삽입
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.end;
            int curWeight = curNode.weight;

            // 이미 더 짧은 경로가 있으면 무시
            if(dist[cur] < curWeight) continue;

            // 인접 정점 탐색
            for(Node nextNode : list.get(cur)){
                if(dist[nextNode.end] > dist[cur] + nextNode.weight){
                    dist[nextNode.end] = dist[cur] + nextNode.weight;
                    pq.offer(new Node(nextNode.end, dist[nextNode.end]));
                }
            }
        }
    }

    // 간선 정보 클래스
    static class Node implements Comparable<Node>{
        int end, weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        // 우선순위 큐: 가중치 오름차순
        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
}
