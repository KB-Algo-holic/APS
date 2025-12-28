# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 42895 - 가장 먼 노드
# 유형: 그래프
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/49189

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] list = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();
        
        for(int[] e : edge) {
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        
        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        int min = 0, maxVal = 0;
        
        Arrays.fill(distance, 20001);
        distance[1] = 0;
        
        for(int i = 1; i <= n; i++) {
            min = 0;
            
            for(int j = 1; j <= n; j++) {
                if(distance[j] < distance[min] && !visited[j])
                    min = j;
            }
            
            if(min == 0)
                break;
            
            visited[min] = true;
            
            for(int next : list[min]) {
                distance[next] = Math.min(distance[next], distance[min] + 1);
                maxVal = Math.max(maxVal, distance[next]);
            }
        }
        
        for(int d : distance) {
            if(d == maxVal)
                answer++;
        }
        
        return answer;
    }
}