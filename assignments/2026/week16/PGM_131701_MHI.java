// PGM 131701 - 연속 부분 수열 합의 개수
// 부분 수열 합
// https://school.programmers.co.kr/learn/courses/30/lessons/131701

import java.util.*;

class Solution {
    public int solution(int[] elements) {

        Set <Integer> set = new HashSet<>();

        for(int i = 0; i < elements.length; i++) {

            int sum = 0;

            for(int j = 0; j < elements.length; j++) {
                sum += elements[(i + j) % elements.length];
                set.add(sum);
            }
        }
        return set.size();
    }
}