// PGM 43165 - 타겟넘버
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java
class Solution {

    int[] numbers;
    int target;
    int cnt;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        cnt = 0;
        dfs(0, 0);        
        return cnt;
    }

    public void dfs(int index, int sum) {
        
        if (index == numbers.length) {
            if (sum == target) cnt++;
            return;
        }
        
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }

}
