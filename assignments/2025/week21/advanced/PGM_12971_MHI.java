class Solution {

    static int[][] dp;
    public int solution(int sticker[]) {

        dp = new int[2][sticker.length];
        for (int i=0; i<2; i++)
            for (int j=0; j<sticker.length; j++)
                dp[i][j] = -1;

        dp[0][0] = makeAns(0,1, sticker);
        dp[1][0] = makeAns(1,2, sticker) + sticker[0];

        return Math.max(dp[0][0], dp[1][0]);
    }

    public int makeAns(int start, int index, int[] sticker) {
        if (index == sticker.length-1) {
            if (start == 1) return 0;
            else return sticker[index];
        } else if (index >= sticker.length) {
            return 0;
        }

        if (dp[start][index] >= 0) return dp[start][index];

        dp[start][index] = Math.max(
                makeAns(start,index + 1, sticker),
                makeAns(start,index + 2, sticker) + sticker[index]
        );

        return dp[start][index];
    }
}