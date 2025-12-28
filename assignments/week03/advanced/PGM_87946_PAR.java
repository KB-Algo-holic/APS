# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 87946 - 피로도
# 유형: 완전탐색
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/87946

import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = 0, length = dungeons.length;
        PriorityQueue<Exploration> pq = new PriorityQueue<>();
        
        for(int i = 0; i < length; i++) {
            if(dungeons[i][0] <= k) {
                boolean[] visited = new boolean[length];
                visited[i] = true;
                
                pq.offer(new Exploration(1, k - dungeons[i][1], visited));
            }
        }
        
        while(!pq.isEmpty()) {
            Exploration ex = pq.poll();
            answer = Math.max(answer, ex.cnt);
            
            if(ex.cnt == length)
                break;
            
            for(int i = 0; i < length; i++) {
                boolean[] visited = Arrays.copyOf(ex.visited, length);
                
                if(!visited[i] && dungeons[i][0] <= ex.k) {
                    visited[i] = true;
                    pq.offer(new Exploration(ex.cnt + 1, ex.k - dungeons[i][1], visited));
                }
            }
        }
        
        return answer;
    }
    
    private class Exploration implements Comparable<Exploration> {
        int cnt, k;
        boolean[] visited;
        
        public Exploration(int cnt, int k, boolean[] visited) {
            this.cnt = cnt;
            this.k = k;
            this.visited = visited;
        }
        
        @Override
        public int compareTo(Exploration o) {
            if(this.cnt == o.cnt)
                return Integer.compare(o.k, this.k);
            
            return Integer.compare(o.cnt, this.cnt);
        }
    }
}