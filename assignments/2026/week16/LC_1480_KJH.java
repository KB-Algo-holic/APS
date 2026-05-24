// LC 1480. Running Sum of 1d Array
// 구현
// https://leetcode.com/problems/running-sum-of-1d-array/
class Solution {
    public int[] runningSum(int[] nums) {
        
        int[] sums = new int[nums.length];

        for(int i=0 ; i<nums.length ; i++){

            if(i==0){
                sums[i] = nums[i];
                continue;
            }
            sums[i] += sums[i-1]+ nums[i];
        }

        return sums;
    }
}
