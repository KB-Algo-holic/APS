# LC 34 - Find First and Last Position of Element in Sorted Array
# 유형: 이분 탐색
# 링크: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution:
    def lower_bound(self, nums, target):

        start, end = -1, len(nums)

        while start+1 < end:
            mid = (start+end) // 2

            if nums[mid] < target:
                start = mid
            
            else:
                end = mid
        
        return end
    
    def upper_bound(self, nums, target):

        start, end = -1, len(nums)

        while start+1 < end:
            mid = (start+end) // 2

            if nums[mid] <= target:
                start = mid
            
            else:
                end = mid
        
        return start

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        answer = [-1, -1]
        left = self.lower_bound(nums, target)
        right = self.upper_bound(nums, target)
        if left <= right:
            answer = [left, right]
        
        return answer