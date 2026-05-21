/*
1480. Running Sum of 1d Array
https://leetcode.com/problems/running-sum-of-1d-array/
*/
import java.util.*;
class Solution {
    public int[] runningSum(int[] nums) {
        int[] prefix = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        int[] answer = Arrays.copyOfRange(prefix, 1, prefix.length);
        return answer;
    }
}
