// PGM 87946 - 피로도
// 유형: 완전탐색
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/87946

class Solution {
    
    int answer = 0;
    int[] visited;
    
    public void dfs(int t, int[][] dungeons, int cnt) {
        
        if (cnt > this.answer) this.answer = cnt;
        
        for (int i=0; i<dungeons.length; i++) {
            if (this.visited[i] == 0 && t >= dungeons[i][0]) {
                this.visited[i] = 1;
                dfs(t-dungeons[i][1], dungeons, cnt+1);
                this.visited[i] = 0;
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        this.visited = new int[dungeons.length];
        dfs(k, dungeons, 0);
        return this.answer;
    }
}