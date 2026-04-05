// PGM 12909 - 올바른 괄호
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                count++;
            }
            if(s.charAt(i) == ')'){
                count--;
            }
            if(count < 0){
                break;
            }
        }
        
        if(count == 0){
            answer = true;
        }
        
        return answer;
    }
}
