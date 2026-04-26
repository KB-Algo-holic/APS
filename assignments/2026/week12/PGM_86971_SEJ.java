// PGM 86971 - 전력망을 둘로 나누기
// BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/86971?language=java

import java.util.*;
import java.io.*;
// 가능한 개수가 비슷하도록 나눈다.
class Solution {
    
    ArrayList<Integer>[] list;
    int min = (int)1e9;

    public int solution(int n, int[][] wires) {
        
        list = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<n-1;i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            list[v1].add(v2);
            list[v2].add(v1);
            
        }
        
        // 한곳씩 끊어본다
        for(int[] target : wires){
            int v1 = target[0];
            int v2 = target[1];
            
            // v1 -> v2 가는길 제거
            list[v1].remove(Integer.valueOf(v2));
            // v2 -> v2 가는길 제거
            list[v2].remove(Integer.valueOf(v1));
            
            
            int size = bfs(1);
            int diff = Math.abs(size - (n - size));
            // System.out.printlnf(diff)
            min = Math.min(min, diff);
            list[v1].add(v2);
            list[v2].add(v1);
        }
        
        
        return min;
    }
    
    public int bfs(int startV){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] isVisited = new boolean[list.length];
        int cnt = 0;
        
        q.add(startV);
        isVisited[startV] = true;
        
        while(!q.isEmpty()){
            int v = q.poll();
            cnt+=1;
            
            //갈수 있는 곳을 간다
            for(int next : list[v]){
                if(isVisited[next]) continue;   // 이미 갔던 곳이면? 가지 않는다.
                q.add(next);
                isVisited[next] = true;
            }
            
        }
        
        return cnt;
    }   
}