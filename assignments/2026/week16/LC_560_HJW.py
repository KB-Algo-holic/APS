# LC 560 - Subarray Sum Equals K
# 유형: 누적합
# 링크: https://leetcode.com/problems/subarray-sum-equals-k/description/

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        answer = 0
        tmp = 0
        table = dict()
        table[0] = 1
        for num in nums:
            tmp += num
            answer += table.get(tmp-k, 0)
            table[tmp] = table.get(tmp, 0) + 1
        
        return answer