// PGM 49191 - 순위
// 그래프
// https://school.programmers.co.kr/learn/courses/30/lessons/49191

class Solution {

    public int solution(int n, int[][] results) {

        boolean[][] gp = new boolean[n+1][n+1];

        for(int i = 0; i < results.length; i++){
            gp[results[i][0]][results[i][1]] = true;
        }

        for(int k = 1; k < n+1; k++){
            for(int i = 1; i < n+1; i++){
                for(int j = 1; j < n+1; j++){
                    if(gp[i][j] || (gp[i][k] && gp[k][j])){
                        gp[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;

        for(int i = 1; i < n+1; i++){
            int count = 0;
            for(int j = 1; j < n+1; j++){
                if(gp[i][j] || gp[j][i]){
                    count++;
                }
            }
            if(count == n-1){
                answer++;
            }
        }
        return answer;
    }
}