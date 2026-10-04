// 힌트 스테이지
// DFS
// https://school.programmers.co.kr/learn/courses/30/lessons/468377

import java.util.*;

class Solution {
    int minSum = Integer.MAX_VALUE;
    
    void DFS(int[][] cost, int[][] hint, int[] hintArr, int sum, int t) {
        int v = 0;
        if(sum >= minSum) {
            return;
        }
        
        if(t == cost.length) {
            if(sum < minSum) {
                minSum = sum;
            }
            return;
        }
            
        v = cost[t][Math.min(hintArr[t], cost[t].length - 1)];
        
        DFS(cost, hint, hintArr, sum + v, t + 1);

        if(t < cost.length - 1) {
            for(int k = 1; k < hint[t].length; k++) {
                hintArr[hint[t][k] - 1]++;
            }

            DFS(cost, hint, hintArr, sum + v + hint[t][0], t + 1);

            for(int k = 1; k < hint[t].length; k++) {
                hintArr[hint[t][k] - 1]--;
            }
        }
    }
    
    public int solution(int[][] cost, int[][] hint) {
        int[] hintArr = new int[cost.length];
        
        DFS(cost, hint, hintArr, 0, 0);
    
        return minSum;
    }
}
