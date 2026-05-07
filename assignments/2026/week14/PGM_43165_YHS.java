// PGM - 43165 L2_타겟넘버
// DFS/BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class PGM_43165_YHS {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    void dfs(int[] numbers, int target, int idx, int sum){
        if(idx == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }

        dfs(numbers, target, idx+1, sum+numbers[idx]);
        dfs(numbers, target, idx+1, sum-numbers[idx]);
    }
}
