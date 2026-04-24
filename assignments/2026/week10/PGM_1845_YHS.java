// PGM - 1845 L1_폰켓몬
// 그래프
// https://school.programmers.co.kr/learn/courses/30/lessons/1845

import java.util.HashSet;
import java.util.Set;

public class PGM_1845_YHS {
    public int solution(int[] nums) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        if(set.size() > nums.length/2){
            answer = nums.length/2;
        }else{
            answer = set.size();
        }
        return answer;
    }
}
