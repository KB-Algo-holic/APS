// PGM 피로도 - 87946
// 완전탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/87946
class Solution {
    static private int max =0;
    static private int dept = 0;
    static private boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        dept = dungeons.length;
        visit = new boolean[dept];
        dfs(k,dungeons,0);
        
        return max;
    }
    
    public void dfs(int k, int[][] dungeons,int cnt)
    {
        if(cnt>=dept)
        {
            if(max < cnt)
                max = cnt;
            return;
        }
        
        if(max < cnt)
                max = cnt;
        
        for(int i=0;i<dept;i++)
        {
            if(!visit[i] && dungeons[i][0]<= k)
            {
                visit[i] = true;
                dfs(k-dungeons[i][1],dungeons,cnt+1);
                visit[i] = false;
                
            }
        }
        
    }
}
