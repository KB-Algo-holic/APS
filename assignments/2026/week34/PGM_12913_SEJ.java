import java.util.*;

class Solution {
    int result = 0;
    int[][] memo;
    int N = 0;
    int solution(int[][] land) {
        N = land.length;
        memo = new int[N][4];
        
        // 1. 초기화 진행
        for(int i=0;i<4;i++){
            memo[0][i] = land[0][i];
        }
        
        
        // 2. memo하면서 내려오기 진행
        for(int i=1;i<N;i++){
            memo[i][0] = land[i][0] 
                            + Math.max(memo[i-1][1], Math.max(memo[i-1][2], memo[i-1][3]));
            memo[i][1] = land[i][1] 
                            + Math.max(memo[i-1][0], Math.max(memo[i-1][2], memo[i-1][3]));
            memo[i][2] = land[i][2] 
                            + Math.max(memo[i-1][0], Math.max(memo[i-1][1], memo[i-1][3]));
            memo[i][3] = land[i][3] 
                            + Math.max(memo[i-1][0], Math.max(memo[i-1][1], memo[i-1][2]));
        }
        
        

        return Math.max(memo[N-1][0] 
                        ,Math.max(memo[N-1][1]
                        , Math.max(memo[N-1][2], memo[N-1][3])));
    }
}
