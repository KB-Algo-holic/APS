// PGM 72410 - 신규 아이디 추천
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/72410

class Solution {
    public String solution(String new_id) {
        String answer = "";
        String temp = "";
        
        // 1단계
        for(int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            
            if('A' <= ch && ch <= 'Z') {
                ch -= 'A';
                ch += 'a';
            }
            
            temp += ch;
        }
        answer = temp;
        
        // 2단계
        temp = "";
        for(int i = 0; i < answer.length(); i++) {
            char ch = answer.charAt(i);
        
            if((('a' <= ch && ch <= 'z') || ('0' <= ch && ch <= '9') || ch == '-' || ch == '_' || ch == '.')) {
                temp += ch;    
            }
        }
        answer = temp;
        
        // 3단계
        temp = "";
        for(int i = 0; i < answer.length(); i++) {
            char ch = answer.charAt(i);
        
            if(ch == '.' && i < answer.length() + 1) {
                for(int j = i + 1; j < answer.length(); j++) {
                    if(answer.charAt(j) == '.') {
                        i++;
                    } else {
                        break;
                    }
                }
            }
            
            temp += ch;
        }
        answer = temp;
        
        // 4단계
        if(answer.length() > 0) {
            if(answer.charAt(0) == '.') {
                answer = answer.substring(1);
            }
        }
        if(answer.length() > 0) {
            if(answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        
        // 5단계
        if(answer.length() == 0) {
            answer = "a";
        }
        
        // 6단계
        if(answer.length() > 15) {
            answer = answer.substring(0, 15);
            
            while(answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
                if(answer.length() == 0) {
                    break;
                }
            }
        }
        
        // 7단계
        while(answer.length() < 3 && answer.length() > 0) {
            answer += answer.charAt(answer.length() - 1);
        }
        
        return answer;
    }
}
