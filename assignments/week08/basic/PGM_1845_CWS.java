// PGM 1845 - 폰켓몬
// 유형: 해시
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/1845
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet hs = new HashSet();
        for(int n : nums){
            hs.add(n);
        }
        //중복되는 폰켓몬 종류가 전체의 반이 안되는 경우 최소값 다르게 함
        return Math.min(hs.size(), nums.length/2);
    }
}