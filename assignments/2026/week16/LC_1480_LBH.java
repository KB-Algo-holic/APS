// Running Sum of 1d Array
// 누적합
// https://leetcode.com/problems/running-sum-of-1d-array

class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0;

        int[] answer = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            answer[i] = sum;
        }

        return answer;
    }
}