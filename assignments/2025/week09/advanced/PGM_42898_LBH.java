// PGM 42898 - 등굣길
// 유형: 동적계획법
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42898

class Solution {
    public int solution(int m, int n, int[][] puddles) {

        int[][] map = new int[m + 1][];
        for(int i = 0; i < map.length; i++) {
            map[i] = new int[n + 1];
        }

        map[1][1] = 1;
        for(int[] puddle : puddles) {
            map[puddle[0]][puddle[1]] = -1;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++) {
                if(i == 1 && j == 1) {
                    continue;
                } else if(map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                } else {
                    map[i][j] = (map[i - 1][j] + map[i][j - 1]) % 1000000007;
                }
            }

        }

        return map[m][n];
    }
}