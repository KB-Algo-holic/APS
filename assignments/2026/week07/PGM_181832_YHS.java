public class PGM_181832_YHS {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int r=0;
        int c=0;

        int cnt=n;

        int d = 0;
        boolean isVisited[][] = new boolean [n][n];

        int cur = 1;
        answer[0][0] = 1;
        isVisited[0][0] = true;
        int max = n*n*n;
        int t = 0;
        while(t <= max){

            int nr = r+dr[d];
            int nc = c+dc[d];

            if(isIn(nr, nc, n) && !isVisited[nr][nc]){
                answer[nr][nc] = ++cur;
                isVisited[nr][nc] = true;
                r = nr;
                c = nc;
            }else{
                d = (d+1) % 4;
            }
            t++;
        }
        return answer;
    }
    boolean isIn (int r, int c, int n){
        return (r>=0 && r<n && c>=0 && c<n);
    }

    int dr[] = {0,1,0,-1};
    int dc[] = {1,0,-1,0};
}
