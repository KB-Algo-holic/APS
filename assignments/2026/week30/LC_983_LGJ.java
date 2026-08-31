// LC - 983 minimum-cost-for-tickets
// DP, DFS, Memoization
// https://leetcode.com/problems/minimum-cost-for-tickets/


class Solution {
    int[] days;
    int[] costs;
    Integer[] memo;

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        this.memo = new Integer[days.length];

        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= days.length) {
            return 0;
        }

        if (memo[i] != null) {
            return memo[i];
        }

        int oneDay = costs[0] + dfs(i + 1);

        int j = i;
        while (j < days.length && days[j] < days[i] + 7) {
            j++;
        }
        int sevenDay = costs[1] + dfs(j);

        j = i;
        while (j < days.length && days[j] < days[i] + 30) {
            j++;
        }
        int thirtyDay = costs[2] + dfs(j);

        return memo[i] = Math.min(
                oneDay,
                Math.min(sevenDay, thirtyDay)
        );
    }
}