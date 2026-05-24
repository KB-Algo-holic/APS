// PGM - 42861 섬 연결하기
// UNION & FIND
// https://school.programmers.co.kr/learn/courses/30/lessons/42861

import java.util.*;

class Solution {
    int[] parents;
    
    public int solution(int n, int[][] costs) {
        parents = new int[n];
        for(int i=0;i<n;i++){
            parents[i] = i;
        }
        int cost = 0;
        Arrays.sort(costs, Comparator.comparingInt((int[] o) -> o[2]));
        for(int i=0;i<costs.length;i++){
            // System.out.println(Arrays.toString(costs[i]));
            // 이어 본다~!
            int x = costs[i][0];
            int y = costs[i][1];
            int c = costs[i][2];
            
            if(find(x) != find(y)){
                cost +=c;
                union(x, y);
            }
        }
        
        return cost;
    }
    
    
    int find(int x){
        if(x==parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
    
    void union(int x, int y){
        x = find(x);
        y = find(y);
        
         if (x < y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }
}