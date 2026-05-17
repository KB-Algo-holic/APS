// PGM 43162 - 네트워크
// 학습 이해하려 노력중; 
// https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=java
class Solution {
    
    int n;
    int[][] computers;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        this.n = n;
        this.computers = computers;
        this.visited = new boolean[n];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            
            if (!visited[i]) {
                dfs(i);
                cnt++; 
            }
        }

        return cnt;
    }
    
    public void dfs(int node) {
        visited[node] = true;

        for (int i = 0; i < n; i++) {
            
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
