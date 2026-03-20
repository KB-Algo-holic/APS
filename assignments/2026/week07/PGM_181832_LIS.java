// PGM 181832 - 정수를 나선형으로 배치하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/181832
class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];       

        int cnt = n * n;

        int x   = 0;
        int y   = 0;
        int pX[] = {0, 1,  0, -1};
        int pY[] = {1, 0, -1,  0};
        int p    = 0;       

        System.out.println("cnt : " + cnt );

        for(int i=1; i <= cnt; i++) {

            answer[x][y] = i;

            System.out.println("(" + x + "," + y + ") = " + answer[x][y]);
            int nX = x + pX[p];
            int nY = y + pY[p];           

            if (nX >= n || nY >= n || nX < 0 || nY < 0 || answer[nX][nY] != 0) {
                p = (p+1)%4;
                nX = x + pX[p];
                nY = y + pY[p];
            }
            x = nX;
            y = nY;
        }
        return answer;
    }
}
