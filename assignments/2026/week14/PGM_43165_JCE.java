/*
 * PGM 43165 - 타겟 넘버
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
*/

class Solution {
    public static int solution(int[] numbers, int target) {
    int answer = 0;
    answer = dfs(0, 0, numbers, target);
    return answer;
}

private static int dfs(int index, int total, int[] numbers, int target) {
    int answer = 0;
    // 종료조건 : numbers 길이 다 돌았을 때
    //           target값과 같으면 +1
    if (index == numbers.length) {
        if (total == target) return 1;
        else return 0;
    }
    // numbers 재귀 값 더하기
    answer += dfs(index + 1, total + numbers[index], numbers, target);
    // numbers 재귀 값 빼기
    answer += dfs(index + 1, total - numbers[index], numbers, target);

    return answer;
}
}
