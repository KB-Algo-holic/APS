// [LC] 547 - Number of Provinces
// DFS
// leetcode.com/problems/number-of-provinces/
import java.util.*;
class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        visited[0] = false;
        for (int i = 0 ; i < isConnected.length; i ++){
            if(visited[i] == false){
                que.offer(i);
                answer++;
                visited[i] = true;
                while(!que.isEmpty()){
                    int x = que.poll();
                    for(int j = 0 ; j < isConnected.length; j++){
                        if(isConnected[x][j] == 1 && visited[j] == false){
                            que.offer(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
