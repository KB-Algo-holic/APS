# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 42862 - 체육복
# 유형: 그리디
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42862

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        boolean[] visited = new boolean[n + 2];
        Arrays.fill(visited, true);
        
        for(int i : lost)
            visited[i] = false;
        
        Arrays.sort(reserve);
        
        for(int i = 0; i < reserve.length; i ++) {
            int num = reserve[i];
            
            if(!visited[num]) {
                visited[num] = true;
                answer++;
            } else if(!visited[num - 1]) {
                visited[num - 1] = true;
                answer++;
            } else if(!visited[num + 1] && (i == reserve.length - 1 || reserve[i + 1] != num + 1)) {
                visited[num + 1] = true;
                answer++;
            }
        }
        return answer;
    }
}