// PGM_181932 코드 처리하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/181932

class Solution {
    public String solution(String code) {
        String answer = "";
        char mode = '0';
        for(int i = 0; i < code.length(); i ++){
            if (code.charAt(i) == '1') {
                mode = ChgMode(mode);
                continue;
            }
            
            if(mode == '1' && i % 2 == 1){
                answer += code.charAt(i);
            }
            if(mode == '0' && i % 2 == 0){
                answer += code.charAt(i);
            }
        }
        if(answer == "")
            answer = "EMPTY";
        return answer;
    }
    
    public char ChgMode(char mode){
        if(mode == '1')
            return '0';
        else
            return '1';
    }
}

 
