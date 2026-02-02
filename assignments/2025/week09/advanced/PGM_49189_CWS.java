// PGM 49189 - 가장 먼 노드
// 유형: 그래프
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/49189

import java.util.*;

class Solution {

    static ArrayList<Integer>[] list;
    static boolean[] checked;
    static int answer = 0;
    static Queue<Integer> queue;

    public int solution(int n, int[][] edge) {

        checked = new boolean[n+1];
        answer = 0;
        queue = new LinkedList<>();
        list = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < edge.length; i++){
            //리스트 배열에 값 입력 ex)1,3 3,1
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        checked[1] = true;
        move(1,true,0);

        return answer;
    }

    static void move(int num, boolean check, int cnt){
        if(cnt == answer){
            cnt = 0;
            check = true;
        }
        //노드의 리스트값 큐에 입력
        for(int i = 0; i < list[num].size(); i++){
            if(!checked[list[num].get(i)])
                queue.offer(list[num].get(i));
            checked[list[num].get(i)] = true;
        }
        //노드의 최대거리를 알기위해 큐가 한바퀴 돌때까지를 체크
        if(!queue.isEmpty()){
            if(check){
                answer = queue.size();
                check = false;
            }
            move(queue.poll(), check, cnt+1);
        }
    }
}