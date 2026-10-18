// PGM 43165 - 타겟 넘버
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java

public class PGM_43165_PST {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, 0, 0);
        return answer;
    }

    private int dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        }
        return dfs(numbers, target, index + 1, sum + numbers[index])
                + dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}