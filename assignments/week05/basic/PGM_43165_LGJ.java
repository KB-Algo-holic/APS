// PGM 43165 - 타겟넘버
// 유형: DFS
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43165


import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int[] count = new int[1];
        dfs(numbers, 0, 0, target, count);

        return count[0];
    }

    public void dfs(int[] numbers, int depth, int currentSum, int target, int[] count) {
        if (depth == numbers.length) {
            if (currentSum == target) {
                count[0]++;
            }
            return;
        }

        // 현재 숫자를 더하는 경우
        dfs(numbers, depth + 1, currentSum + numbers[depth], target, count);
        // 현재 숫자를 빼는 경우
        dfs(numbers, depth + 1, currentSum - numbers[depth], target, count);
    }
}