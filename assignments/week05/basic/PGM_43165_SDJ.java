# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 43165 - 타겟 넘버
# 유형: 정렬
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43165

import java.util.*;

class Solution { 
	
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    
    public void dfs(int[] numbers, int target, int idx, int sum){
        if(idx == numbers.length){
            if(target == sum) answer++;
            return;
        }
        dfs(numbers, target, idx+1, sum+numbers[idx]);
        dfs(numbers, target, idx+1, sum-numbers[idx]);        
    }
}