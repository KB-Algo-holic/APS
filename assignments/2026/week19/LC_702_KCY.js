// LC 702 - Binary Search
// 유형: 구현
// 링크: https://leetcode.com/problems/binary-search/
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
    let left = 0;
    let right = nums.length - 1;

    while (left <= right) {
        // 중간 인덱스
        const mid = Math.floor((left + right) / 2);
        const center = nums[mid];

        if (center === target) {
            return mid;
        }

        if (center < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return -1;
};