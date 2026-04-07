// PGM 133502 - 햄버거 만들기
// 유형: 스택
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/133502

import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int ingre : ingredient) {
            stack.add(ingre);
            
            if (stack.size() >= 4) {
                int lastIdx = stack.size()-1;
                if (stack.get(lastIdx) == 1 &&
                    stack.get(lastIdx-1) == 3 &&
                    stack.get(lastIdx-2) == 2 &&
                    stack.get(lastIdx-3) == 1) {
                    for (int i=0; i<4; i++) stack.pop();
                    answer += 1;
                }
            }
        }
        return answer;
    }
}