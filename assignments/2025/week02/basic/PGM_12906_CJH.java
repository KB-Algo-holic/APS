// PGM 12906 - 같은 숫자는 싫어
// 유형 : 해시
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12906

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> ansList = new ArrayList<Integer>();
        
        for (int i : arr) {
            if (ansList.size() == 0) {
                ansList.add(i);
                
            } else {
                if (ansList.get(ansList.size()-1) == i) continue;
                
                ansList.add(i);
                
            }
            
        }
        
        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }
}
