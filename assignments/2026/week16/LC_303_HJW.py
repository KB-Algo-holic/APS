# LC 303 - Range Sum Query - Immutable
# 유형: 누적합
# 링크: https://leetcode.com/problems/range-sum-query-immutable/

class NumArray:
    dp = [0]
    def __init__(self, nums: List[int]):
        self.dp = [0]
        for num in nums:
            self.dp.append(self.dp[-1] + num)
        print(self.dp)

    def sumRange(self, left: int, right: int) -> int:
        return self.dp[right+1] - self.dp[left]


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)