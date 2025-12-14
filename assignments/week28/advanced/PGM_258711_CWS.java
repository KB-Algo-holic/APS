import java.util.*;

class Solution {

    // a1: 생성 정점
    // a2: 도넛 그래프 개수
    // a3: 막대 그래프 개수
    // a4: 8자 그래프 개수
    static int a1, a2, a3, a4;

    // line: 간선 수
    // max: 특정 정점의 최대
    static int line, max;
    // b1: 정점의 전체 차수 (방문 여부 체크용)
    // b2: 정점의 in-degree
    static int[] b1, b2;
    // 인접 리스트
    static HashMap<Integer, List<Integer>> hm;
    // DFS 중 방문한 정점 집합
    static HashSet<Integer> vertax;
    // 임시 리스트
    static List<Integer> list;

    public int[] solution(int[][] edges) {
        b1 = new int[1000001];
        b2 = new int[1000001];

        hm = new HashMap<>();
        list = new ArrayList<>();

        max = 1;
        for(int[] edge : edges){
            b1[edge[0]]++;   // out
            b1[edge[1]]++;   // in
            b2[edge[1]]++;   // in-degree

            // 인접 리스트 구성
            if(hm.get(edge[0]) == null){
                list = new ArrayList<>();
                list.add(edge[1]);
                hm.put(edge[0], list);

                // 최초 후보 생성 정점
                if(max <= 1) a1 = edge[0];
            } else {
                list = hm.get(edge[0]);
                list.add(edge[1]);
                hm.put(edge[0], list);

                // out-degree가 가장 큰 정점을 생성 정점 후보로
                if(max < list.size()){
                    max = list.size();
                    a1 = edge[0];
                }
            }
        }

        // in-degree가 0이고 out-degree가 최대인 정점이 진짜 생성 정점
        for(int i = 1; i < 1000001; i++){
            list = hm.get(i);
            if(list != null && list.size() == max && b2[i] == 0){
                a1 = i;
                break;
            }
        }

        // 그래프 분석
        for(int j : list){
            if(b1[j] != 0){
                vertax = new HashSet<>();
                line = 0;
                move(j, j);

                if(vertax.size() == line){
                    a2++;          // 도넛
                } else if(vertax.size() == line + 1){
                    a3++;          // 막대
                } else if(vertax.size() == line - 1){
                    a4++;          // 8자
                }
            }
        }

        return new int[]{a1, a2, a3, a4};
    }

    private static void move(int i, int s){
        if(b1[i] != 0){
            vertax.add(i); // 정점 방문
            b1[i] = 0;     // 방문 처리

            list = hm.get(i);
            if(list == null) return;

            for(int j : list){
                line++;    // 간선 수 증가
                move(j, s);
            }
        }
    }
}
