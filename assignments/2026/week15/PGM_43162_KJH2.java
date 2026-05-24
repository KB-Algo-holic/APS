// PGM_43162 네트워크
// BFS
// school.programmers.co.kr/learn/courses/30/lessons/43162
import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                answer++;
                visited[i] = true;
                que.offer(i);
            }
            while(!que.isEmpty()){
                int x = que.poll();
                for(int j = 0; j < n ; j++){
                    if(computers[x][j] == 1 && !visited[j]){
                        visited[j] = true;
                        que.offer(j);
                    }
                }
            }
        }
        return answer;
    }
}
