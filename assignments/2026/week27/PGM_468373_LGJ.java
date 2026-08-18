// 모의고사
// PGM - 768373 바이러스파이프
// 그래프, 완전탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/468373

import java.util.*;

class Solution {
    int maxCnt = 0;
    Map<Integer, Set<Integer>> map = new HashMap<>();

    public int solution(int n, int infection, int[][] edges, int k) {
        // 연결 그래프 표현 (양방향)
        int[][] graph = new int[n+1][n+1]; // s-e-v
        for (int[] edge: edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            int pipe = edge[2];

            graph[n1][n2] = pipe;
            graph[n2][n1] = pipe;
            map.putIfAbsent(pipe, new HashSet<>());
            map.get(pipe).add(n1);
            //map.get(pipe).add(n2);
        }
        //System.out.println(map);

        //System.out.println(Arrays.deepToString(graph));
        // perm : k번 순서 A(1), B(2), C(3)를 여는 perm

        // simulation : perm 순서를 통해 감염 개체를 확인
        // start(infections) -> start 연결된

        perm(k, 0, new int[k], graph, infection);
        return maxCnt;
    }
    // todo : backtracking
    void perm(int k, int idx, int[] cur, int[][] graph, int infection) {

        if (idx == k) {
            //System.out.println(Arrays.toString(cur));
            int cnt = simulation(infection, graph, cur);
            //System.out.println(cnt);
            if (maxCnt < cnt) maxCnt = cnt;
            return ;
        }

        for (int i=1; i<=3; i++) {
            cur[idx] = i;
            perm(k, idx+1, cur, graph, infection);
        }

    }

    int simulation(int infection, int[][] graph, int[] pipes) {

        int n = graph.length;
        boolean[] infections = new boolean[n+1];
        infections[infection] = true;

        for (int p : pipes) {
            Queue<Integer> q = new ArrayDeque<>();

            for (int node = 1; node < graph.length; node++) {
                if (infections[node]) {
                    q.offer(node);
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();

                // 연결 노드 확인
                for (int nextNode = 1; nextNode < graph.length; nextNode++) {
                    int pipeType = graph[cur][nextNode];

                    if (infections[nextNode]) continue;

                    if (pipeType == p) {
                        infections[nextNode] = true;
                        q.offer(nextNode);
                    }
                }
            }
        }
        int cnt = 0;
        for (boolean isInfection : infections) {
            if (isInfection) cnt ++;
        }


        return cnt;
    }
}