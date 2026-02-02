import java.util.*;
class Solution {
    static int[][] dp;
    public int solution(int[][] triangle) {
        dp = new int[triangle.length][triangle.length];
        for(int i=0; i<triangle.length; i++) Arrays.fill(dp[i],-1);

        int answer = makeAnswer(triangle, 0, 0);

        return answer;
    }

    public int makeAnswer(int[][] tree, int step, int index) {
        if(dp[step][index] != -1) return dp[step][index];

        if(step == tree.length-1) return tree[step][index];

        int plus = Math.max(makeAnswer(tree, step+1,index), makeAnswer(tree,step+1,index+1));

        return dp[step][index] = tree[step][index] + plus;
    }
}