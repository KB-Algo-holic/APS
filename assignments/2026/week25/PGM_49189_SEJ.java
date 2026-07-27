// solve: [PGM] 49189 - 가장먼노드 풀이완료
// https://school.programmers.co.kr/learn/courses/30/lessons/49189
// [PGM] 49189 - 가장먼노드
// BFS

import java.util.*;
class Solution {
    
    
    // boolean[] isVisited;
    ArrayList<Integer>[] list;
    int[] memo;
    int result = 0;
    int max = 0;
    
    public int solution(int n, int[][] edge) {
        
        // 내가 갈수 있는 곳에서 가장 먼 노드 찾기
        
        // ======= 초기화 시작 ==========
        // isVisited = new boolean[n+1];
        list = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            list[i] = new ArrayList<Integer>();
        }
        
        for(int[] e : edge){
            int v1 = e[0];
            int v2 = e[1];
            
            list[v1].add(v2);
            list[v2].add(v1);
        }
        
        memo = new int[n+1];
        Arrays.fill(memo, (int)1e9);
        // ======== 초기화 종료 =========
        
        
        bfs();
        //System.out.println(Arrays.toString(memo));
        return result;
    }
    
    
    public void bfs(){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        // 가장 시작 정점을 넣어준다.
        q.add(1);
        //isVisited[1] = true;
        memo[1] = 1;
        max = 1;
        result =0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            //System.out.printf("%d 뽑아따!!!!\n", cur);
            
            if(memo[cur]==max) result+=1;
            if(memo[cur]>max){
                max = memo[cur];
                result = 1;
            }
            
            // 내가 갈 수 있는 곳일깡?
            for(int next : list[cur]){
                if(memo[next] <(int)1e9) continue;
                memo[next] = memo[cur]+1;
                q.add(next);
            }
            
        }
    }
}
