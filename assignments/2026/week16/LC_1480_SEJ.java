// LC 1480 - Running Sum of 1d Array
// 누적합
// https://leetcode.com/problems/running-sum-of-1d-array/description/


class Solution {
    public int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];

        sum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i] = sum[i-1] + nums[i];
        }

        return sum;
    }
}