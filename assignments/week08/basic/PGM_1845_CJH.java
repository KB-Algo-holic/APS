// PGM 1845 - 폰켓몬
// 유형 : 해시
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/1845

import java.util.*;

public class Solution {

    public int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for(int a : nums)
            hs.add(a);

        int N = nums.length/2;

        if(N<hs.size()) {
            return N;
        } else {
            return hs.size();
        }
    }
}