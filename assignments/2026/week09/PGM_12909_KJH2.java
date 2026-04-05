// PGM_12909 올바른 괄호
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12909
class Solution {
    boolean solution(String s) {
        int chk = 0;
        if(s.charAt(0) ==')'){
            return false;
        }
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                chk++;
            }
            if(s.charAt(i) == ')'){
                chk--;
            }
            if(chk < 0){
                return false;
            }
        }
        if(chk == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
}
