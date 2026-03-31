// PGM-12909 올바른 괄호
// 스택
// https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java


import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> left = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
        
            if(ch=='('){
                left.add('(');
                continue;
            }
            
            if(left.isEmpty()) return false;
            left.pop();
        }
        
        if(!left.isEmpty()) return false;

        return true;
    }
}