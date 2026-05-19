// PGM 43162 - 네트워크
// Union-find
// https://school.programmers.co.kr/learn/courses/30/lessons/43162

import java.util.*;

class Solution {

    static int[] parent;

    public int solution(int n, int[][] computers) {

        HashSet<Integer> hs = new HashSet<>();

        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers[i].length; j++){
                if(computers[i][j] == 1) union(i, j);
            }
        }

        for(int i = 0; i < parent.length; i++){
            hs.add(find(i));
        }

        return hs.size();

    }

    public static int find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            parent[rootY] = rootX;
        }

    }

}