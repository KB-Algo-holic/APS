// PGM 43165 - 타겟 넘버
// 유형: DFS
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43165

class Solution {

    int answer = 0;

    void DFS(int[] numbers, int target, int idx, int sum){
        if(idx == numbers.length){
            if(target == sum){
                answer++;
            }
            return;
        }

        DFS(numbers, target, idx + 1, sum + numbers[idx]);
        DFS(numbers, target, idx + 1, sum - numbers[idx]);

        return;
    }

    public int solution(int[] numbers, int target) {

        DFS(numbers, target, 0, 0);

        return answer;
    }
}