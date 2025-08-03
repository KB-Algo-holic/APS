// PGM 42898 - 등굣길
// 유형: 동적계획법
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42898

class Solution {
    public int solution(int m, int n, int[][] puddles) {

        int[][] map = new int[n][m];
        //시작점
        map[0][0] = 1;
        //웅덩이 -1로 체크
        for(int i = 0; i < puddles.length; i++){
            map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }

        //맨윗줄과 옆줄 1로 입력
        for(int i = 0; i < n; i++){
            if(map[i][0] == -1) //웅덩이인경우 멈춤
                break;
            map[i][0] = 1;
        }
        for(int i = 0; i < m; i++){
            if(map[0][i] == -1)
                break;
            map[0][i] = 1;
        }

        //예를들어 3,3으로 가는 경우는 2,3 3,2 의 합
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i-1 >=0 && j-1 >=0 && map[i][j] != -1){
                    if(map[i-1][j] == -1){//웅덩이 체크1
                        map[i][j] = map[i][j-1];
                    }else if(map[i][j-1]==-1){//웅덩이 체크2
                        map[i][j] = map[i-1][j];
                    }else{
                        map[i][j] = map[i-1][j] + map[i][j-1];
                        //미리 나눠줘야 효율성 통과
                        map[i][j] %= 1_000_000_007;
                    }
                }
            }
        }

        return map[n-1][m-1] % 1_000_000_007;


    }
}