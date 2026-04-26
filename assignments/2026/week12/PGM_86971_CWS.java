// PGM 86971 - 전력망을 둘로 나누기
// 트리
// https://school.programmers.co.kr/learn/courses/30/lessons/86971

import java.util.*;

class Solution {

    static int answer;
    static List<Integer>[] list;

    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < wires.length; i++){
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }
        for(int i = 0; i < wires.length; i++){
            int cnt1 = 0;
            int cnt2 = 0;
            int n1 = wires[i][0];
            int n2 = wires[i][1];

            Queue<Integer> q = new LinkedList<>();
            boolean[] checked = new boolean[n+1];

            for(int j = 0; j < list[n1].size(); j++){
                if(list[n1].get(j) != wires[i][1]){
                    checked[list[n1].get(j)] = true;
                    cnt1++;
                    q.offer(list[n1].get(j));
                }
            }
            cnt1 += move(n1,n2, checked, q);

            q = new LinkedList<>();
            checked = new boolean[n+1];

            // n2에서 시작 (n1로 가는 길 차단)
            for(int j = 0; j < list[n2].size(); j++){
                if(list[n2].get(j) != wires[i][0]){
                    checked[list[n2].get(j)] = true;
                    cnt2++;
                    q.offer(list[n2].get(j));
                }
            }

            cnt2 += move(n1,n2, checked, q);
            // 두 그룹 크기 차이의 최소값 갱신
            answer = Math.min(Math.abs(cnt1-cnt2),answer);
        }

        return answer;
    }

    public static int move(int n1,int n2, boolean[] checked, Queue<Integer> q){
        int cnt = 0;

        while(!q.isEmpty()){
            int n = q.poll();
            for(int j = 0; j < list[n].size(); j++){
                // 방문하지 않았고, 끊은 전선(n1-n2)을 통해 가지 않는 경우
                if(!checked[list[n].get(j)] && !(list[n].get(j) == n1 || list[n].get(j) == n2)){
                    checked[list[n].get(j)] = true;
                    cnt++;
                    q.offer(list[n].get(j));
                }
            }
        }
        return cnt;

    }

}