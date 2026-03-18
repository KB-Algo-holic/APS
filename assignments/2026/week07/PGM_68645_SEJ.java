// 삼각 달팽이
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/68645


class Solution {
    public int[] solution(int n) {
        int[][] memo = new int[n][n];
        int[] dx = {1,0,-1};
        int[] dy = {0,1,-1};
        int dir = 0;
        
        int cx = -1;
        int cy = 0;
        int num = 1;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                cx = cx + dx[dir];
                cy = cy + dy[dir];
                
                // System.out.printf("%d, %d \n", x, y);
                memo[cx][cy] = num++;
            }
            dir = (dir+1)%3;
        }
        
        // ======= 결과 변환 ===========
        int[] result = new int[n*(n+1) / 2];
        int idx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(memo[i][j]==0) break;
                result[idx++] = memo[i][j];
            }
        }
        return result;
    }
}