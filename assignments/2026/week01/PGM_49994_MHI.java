class Solution {
    public int solution(String dirs) {


        boolean[][][] dp = new boolean[11][11][4];
        int x=5, y=5;
        int ans=0;
        for(int i=0; i<dirs.length(); i++) {
            if(dirs.charAt(i)=='U'){
                if(y==10) continue;
                if(!dp[x][y][0]) {
                    dp[x][y][0]=true;
                    ans++;
                }
                y++;
                dp[x][y][1]=true;
            }
            else if(dirs.charAt(i)=='D'){
                if(y==0) continue;
                if(!dp[x][y][1]) {
                    dp[x][y][1]=true;
                    ans++;
                }
                y--;
                dp[x][y][0]=true;
            }
            else if(dirs.charAt(i)=='R'){
                if(x==10) continue;
                if(!dp[x][y][2]) {
                    dp[x][y][2]=true;
                    ans++;
                }
                x++;
                dp[x][y][3]=true;
            }
            else {
                if(x==0) continue;
                if(!dp[x][y][3]) {
                    dp[x][y][3]=true;
                    ans++;
                }
                x--;
                dp[x][y][2]=true;
            }
        }
        return ans;
    }
}