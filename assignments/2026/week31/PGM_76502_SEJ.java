// https://school.programmers.co.kr/learn/courses/30/lessons/76502?language=java

import java.util.*;

class Solution {
    StringBuilder sb;
    int result =0;
    Stack<Character> left;
    
    public int solution(String s) {
         sb = new StringBuilder(s);
        
        // 문자열 길이만큼 회전
        for(int i = 0; i < sb.length(); i++){
            
            // 현재 문자열이 올바른 괄호인지 확인
            if(isPossible()){
                result++;
            }
            
            // 맨 앞 문자를 맨 뒤로 이동
            char first = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(first);
        }
        
        return result;
    }
    
    boolean isPossible(){
      left = new Stack<>();
        
        for(int i = 0; i < sb.length(); i++){
            char ch = sb.charAt(i);
            
            // 여는 괄호
            if(ch == '(' || ch == '{' || ch == '['){
                left.push(ch);
                
            // 닫는 괄호
            }else{
                
                // 닫는 괄호가 나왔는데
                // 대응할 여는 괄호가 없음
                if(left.isEmpty()){
                    return false;
                }
                
                char l = left.peek();
                
                if(l == '(' && ch == ')'){
                    left.pop();
                }else if(l == '{' && ch == '}'){
                    left.pop();
                }else if(l == '[' && ch == ']'){
                    left.pop();
                }else{
                    // 짝이 안 맞음
                    return false;
                }
            }
        }
        
        // 모든 괄호가 정상적으로 닫혔다면 true
        return left.isEmpty();
    }
    
}
