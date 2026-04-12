// PGM 133502 - 햄버거 만들기
// 스택/큐
// https://school.programmers.co.kr/learn/courses/30/lessons/133502

import java.util.*;

class Solution {
    public int solution(int[] ingredient) {

        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int i = 0; i < ingredient.length; i++){
            if(ingredient[i] == 1 && stack.size() >= 3){
                int n1 = stack.pop(); //고기
                int n2 = stack.pop(); //야채
                int n3 = stack.pop(); //빵
                if(n1 == 3 && n2 == 2 && n3 == 1){
                    answer++;
                }else{
                    stack.push(n3);
                    stack.push(n2);
                    stack.push(n1);
                    stack.push(ingredient[i]);
                }

            }else{
                stack.push(ingredient[i]);
            }
        }

        return answer;
    }
}