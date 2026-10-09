// PGM 42883 - 큰 수 만들기
// 학습
// https://school.programmers.co.kr/learn/courses/30/lessons/42883
import java.util.*;

class Solution {
    static int N, K;
    static int[] answer;

    public String solution(String number, int k) {
        N = number.length();
        K = k;

        Stack<Integer> stk = new Stack<>();

        for(int idx = 0; idx < number.length(); ++idx) {
            int currNum = number.charAt(idx) - '0';
            // 비어있을 경우 push
            if(stk.isEmpty()) {
                stk.push(currNum);
                continue;
            }

            int remainNum = N - idx; 
            // stack이 비거나, 숫자 완성을 위한 최소 숫자 개수를 만족할 때까지 반복
            while(!stk.isEmpty() && stk.size() + remainNum > N - K) {
                if(stk.peek() < currNum) {
                    stk.pop();
                }else{
                    break;
                }
            }

            if(stk.size() < N - K){
                stk.push(currNum);        
            }
        }
        return getAnsString(stk);
    }

    // Stack to String
    public String getAnsString(Stack<Integer> ans) {
        StringBuilder sb = new StringBuilder();
        for(int elem : ans) {
            sb.append(String.valueOf(elem));
        }
        return sb.toString();
    }
}
