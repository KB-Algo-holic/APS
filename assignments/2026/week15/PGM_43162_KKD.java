// PGM_43162 네트워크
// BFS
// school.programmers.co.kr/learn/courses/30/lessons/43162
class Solution {
    static private boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        
        for(int i=0;i<n;i++)
        {
            if(!visit[i])
            {
                dfs(computers,i,n);
                answer++;
            }
        }
        
        return answer;
    }
    public void dfs(int[][] computers,int x,int n)
    {
        visit[x] =true;
        for(int i=0;i<n;i++)
        {
            if(i==x)
                continue;
            if(!visit[i] && computers[x][i]==1)
            {
                dfs(computers,i,n);
            }
        }
        
    }
}
