class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        memo = [days[-1] * max(costs)] * len(days)

        for i in range(len(days)):
            for pass_day, cost in zip([1, 7, 30], costs):
                j = i
                while j >= 0 and days[j] > days[i] - pass_day:
                    j -= 1

                if j >= 0:
                    memo[i] = min(memo[i], cost + memo[j])
                else:
                    memo[i] = min(memo[i], cost)

        return memo[-1]