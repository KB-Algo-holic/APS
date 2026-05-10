// PGM 43165 - 타겟넘버
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java

class Solution {
    private static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(0, numbers, 0, target);
        return answer;
    }

    private void dfs(int num, int[] numbers, int index, int target) {
        if (index == numbers.length) {
            if (num == target) {
                answer++;
            }
            return;
        }

        dfs(num + numbers[index], numbers, index + 1, target);
        dfs(num - numbers[index], numbers, index + 1, target);
        return;
    }
}
