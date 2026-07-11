// DP

import java.util.*;

class Solution {
    long[] dp;
    public long solution(int n) {
        dp = new long[n+2];
        dp[1]=1;
        dp[2]=2;
        
        for(int i=3;i<n+1;i++){
           dp[i] = (dp[i-2]%1234567)+(dp[i-1]%1234567);
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n]%1234567;
    }
}