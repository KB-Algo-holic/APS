// PGM 1845 - 폰켓몬
// 해시
// https://school.programmers.co.kr/learn/courses/30/lessons/1845

import java.util.*;

class Solution {
    public int solution(int[] nums) {

        HashSet<Integer> numSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            numSet.add(nums[i]);
        }

        return numSet.size() > nums.length / 2 ? nums.length / 2 : numSet.size();
    }
}