// PGM 12906 - 같은 숫자는 싫어
// 유형: 스택
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12906


import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stack = new ArrayList<>();
        int top = 0;

        for (int i = 0; i < arr.length; i++) {
            // 첫 원소
            if (i == 0) {
                stack.add(arr[i]);
            } else if (arr[i] != stack.get(top)) {
                stack.add(arr[i]);
                top += 1;
            }
        }

        // 리스트를 배열로 변환
        int[] answer = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            answer[i] = stack.get(i);
        }
        return answer;
    }
}
