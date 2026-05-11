// PGM - 43162 네트워크
// 유니온파인드
// https://school.programmers.co.kr/learn/courses/30/lessons/43162

import java.util.*;
class Solution {
   
    int[] parents;
    boolean[] isSelected;
    public int solution(int n, int[][] computers) {
        parents = new int[n+1];
        isSelected = new boolean[n+1];
        
        // 부모값 초기화
        for(int i=0;i<n+1;i++){
            parents[i] = i;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i== j) continue;
                if(computers[i][j]==0) continue;
                
                union(i+1, j+1);
            }
        }
        
        System.out.println(Arrays.toString(parents));
        
        int cnt =0;
        for(int i=1;i<n+1;i++){
            int p = find(i);
            if(isSelected[p]) continue;
            isSelected[p] = true;
            cnt++;
        }
        return cnt;
        
    }
    
    public void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y) return;

        if(x < y){
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }
    
    public int find(int x){
        if(parents[x] == x){
            return x;
        }
        
        return find(parents[x]);
    }
    
}