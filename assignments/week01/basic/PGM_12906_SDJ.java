# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 12906 - 같은 숫자는 싫어
# 유형: 스택/큐
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12906?language=java

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<Integer>();
        
        int bfNum = -1;
        for(int num : arr) {
            if(bfNum != num) {
                list.add(num);
                bfNum = num;
            }
        }
        
        answer = new int[list.size()];
        System.out.println("Hello Java");
        for(int idx=0; idx<answer.length; idx++){
            answer[idx] = list.get(idx);
        }
        
        return answer;
    }
}
