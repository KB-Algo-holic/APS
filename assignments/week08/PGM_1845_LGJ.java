// PGM - 포켓몬
// 해시
//https://school.programmers.co.kr/learn/courses/30/lessons/1845

import java.util.*;


class Solution {
    public int solution(int[] nums) {
        int maxCnt = nums.length/2;
        Map<Integer, Integer> typeCnt = new HashMap<>();
        for (int num: nums) {
            typeCnt.put(num, typeCnt.getOrDefault(num, 0) + 1);
        }

        return Math.min(typeCnt.keySet().size(), maxCnt);
    }
}