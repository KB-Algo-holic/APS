// Range Sum Query - Immutable
// 누적합
// https://leetcode.com/problems/range-sum-query-immutable

class NumArray {
    int[] sumArray;
    public NumArray(int[] nums) {
        int sum = 0;
        sumArray = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumArray[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        if(left == 0) return sumArray[right];
        else return sumArray[right] - sumArray[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */