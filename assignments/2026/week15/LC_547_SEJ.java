// LC - 547 Number of Provinces
// UNION & FIND
// https://leetcode.com/problems/number-of-provinces/description/

import java.util.*;

class Solution {
    int[] parents;
    boolean[] isSelected;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parents = new int[n];
        isSelected = new boolean[n];

        // 1. 부모값 초기화 
        for(int i=0;i<n;i++){
            parents[i] = i;
        }

        // 2. 이어보기
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(isConnected[i][j]==0) continue;
                // System.out.printf("%d이랑 %d을 이어본다\n",i,j);
                union(i,j);
            }
        }
        
        int cnt=0;
        for(int i=0;i<n;i++){
            int p = find(i);
            if(isSelected[p]) continue;
            isSelected[p] = true;
            cnt++;
        }
        // System.out.println(Arrays.toString(parents));


        return cnt;
    }

    int find(int x){
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x < y){
            parents[y] = x;
        }else{
            parents[x] = y;
        }
    }
}