# LC 704 - Binary Search
# 유형: 이분 탐색
# 링크: https://leetcode.com/problems/binary-search/

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        answer = -1
        start, end = 0, len(nums)
        
        while start < end:
            mid = (start + end) // 2
            
            if nums[mid] == target:
                answer = mid
                break
            
            if nums[mid] >= target:
                end = mid
            
            else:
                start = mid+1
        
        return answer