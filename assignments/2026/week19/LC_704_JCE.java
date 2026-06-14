/*
* Leet code 704. Binary Search
* https://leetcode.com/problems/binary-search/description/
*/
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = nums.length / 2;
        int answer = -1;
        while(start <= end) {
            if (target == nums[mid]) {
                answer = mid;
                break;
            } else if (target > nums[mid]) {
                start = mid + 1;
                mid = (start + end) / 2;
            } else {
                end = mid - 1;
                mid = (start + end) / 2;
            }

        }
        return answer;
    }
}
