# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 1845 - 폰켓몬
# 유형: 해시
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/1845

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        answer = nums.length/2; //최대 고를 수 있는 포켓몬 수
        
        Arrays.sort(nums);
        
        List<Integer> numList = new ArrayList<Integer>();
        int prev = -1;
        for(int row : nums) {
            //중복 포켓몬 제거
            if(row != prev) {
                numList.add(row);
                prev = row;
            }
        }
        
        if(numList.size() < answer) {
            //중복 제거 후 남은 포켓몬이 최대수보다 작으면 남은 포켓몬 수 리턴
            answer = numList.size();
        }
        
        return answer;
    }
}