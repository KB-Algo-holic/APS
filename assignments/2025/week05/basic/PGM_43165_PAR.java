# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 43165 - 타겟 넘버
# 유형: DFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43165

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }
    
    private int dfs(int[] numbers, int target, int idx, int tot) {
        if(idx == numbers.length) {
            if(tot == target)
                return 1;
            else
                return 0;
        }
        
        int result = 0;
        result += dfs(numbers, target, idx + 1, tot + numbers[idx]);
        result += dfs(numbers, target, idx + 1, tot - numbers[idx]);
        
        return result;
    }
}