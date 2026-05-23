// PGM_131701 연속 부분 수열 합의 개수
// 누적합 배열 및 set을 사용해 자동 중복 제거
// school.programmers.co.kr/learn/courses/30/lessons/131701
import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int[] prefix = new int[elements.length * 2];
        int x = 1;
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i < prefix.length; i++){
            prefix[i] = prefix[i - 1] + elements[i % elements.length];
        }
        while(x <= elements.length){
            for(int i = 0 ; i < prefix.length - x; i++){
                set.add(prefix[i + x] - prefix[i]);
            }
            x++;
        }
        return set.size();
    }
}
