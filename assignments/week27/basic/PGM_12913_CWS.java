// PGM 12913 - 땅따먹기
// 유형: DP
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12913

class Solution {
    int solution(int[][] land) {

        // 최대 점수 누적
        for(int i = 1; i < land.length; i++){
            // 이전 행의 다른 3개 열 중 최대
            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
        }

        return Math.max(
                Math.max(Math.max(land[land.length-1][0], land[land.length-1][1]),
                        land[land.length-1][2]),
                land[land.length-1][3]
        );
    }
}
