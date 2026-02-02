# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 1845 - 폰켓몬
# 유형: 해시
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/1845

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        
        for(int n : nums)
            set.add(n);
        
        return answer = Math.min(answer, set.size());
    }
}