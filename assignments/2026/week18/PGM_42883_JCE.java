/*
 * 프로그래머스 42883 큰 수 만들기
 * 그리디
 * https://school.programmers.co.kr/learn/courses/30/lessons/42883
 */
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int N = number.length();
        StringBuilder sb = new StringBuilder("");
        
        Stack<Integer> stack = new Stack<>();
        stack.push(number.charAt(0) - '0');
        
        for (int i = 1; i < N; i++) {
            int num = number.charAt(i) - '0';
            
            // 넣으려는 숫자가 스택 젤 위 숫자보다 작으면 넣기
            if (stack.peek() >= num) {
                stack.push(num);
                continue;
            }
            
            // 넣으려는 숫자가 스택 맨 위 숫자보다 크면, k개를 넘지않는 선에서 스택 맨 위 숫자 빼기
            while(!stack.isEmpty()) {
                
                int temp = stack.peek();
                
                if (k == 0) break;
                
                if (temp < num) {
                    stack.pop();
                    k--;
                }else  {
                    break;
                }
            }
            stack.push(num);
            
        }
    
        
        while (!stack.isEmpty()){
            
            // number가 내림차순이면 뒤에서부터 k개 잘라내기
            if (k != 0) {
                stack.pop();
                k--;
                continue;
            }
            sb.insert(0, stack.pop());
        }
        
        return sb.toString();
    }
}
