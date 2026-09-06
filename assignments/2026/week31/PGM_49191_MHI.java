// PGM 49191 - 순위
// 그래프
// https://school.programmers.co.kr/learn/courses/30/lessons/49191

class Solution {
    public int solution(int n, int[][] results) {
        
        boolean[][] g = new boolean[n+1][n+1];
        for(int i=0; i<results.length; i++) {
            g[results[i][0]][results[i][1]]=true;
        }
        
        for(int x=1; x<=n; x++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(x==i||x==j||i==j) continue;
                    if(g[i][x]&&g[x][j]) g[i][j]=true;
                }
            }
        }
        int ans=0;
        for(int i=1; i<=n; i++) {
            boolean possible = true;
            for(int j=1; j<=n; j++) {
                if(i==j) continue;
                if(!g[i][j]&&!g[j][i]) {
                    possible=false;
                    break;
                }
            }
            if(possible) ans++;
        }
        return ans;
    }
}