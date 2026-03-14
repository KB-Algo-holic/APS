// PGM 72410 - 신규 아이디 추천
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/72410

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        //1.소문자로 치환
        answer = new_id.toLowerCase();
                
        //2.소문자,숫자,-_. 나머지문자 제거
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
                
        //3.문자열에 마침표 두개일경우 하나로 치환
        answer = answer.replaceAll("\\.+", ".");
                
        //4-1.첫문자 .이면 제거
        if(answer.charAt(0) == '.'){
            answer = answer.substring(1);
        }
                
        //4-2.마지막문자 .이면 제거
        if(answer.endsWith(".")){
            answer = answer.substring(0, answer.length() - 1);
        }
                
        //5.빈문자열이면 a대입
        if(answer.length() == 0){
            answer = "a";
        }
                
        //6.길이가 16이상일경우 앞15 이후 문자 제거
        if(answer.length() >= 16){
            answer = answer.substring(0,15);
            //마지막문자 .이면 제거
            if(answer.endsWith(".")){
            answer = answer.substring(0, answer.length() - 1);
            }
        }
                
        //7.길이가 2자이하면 마지막문자를 3자리까지 반복
        if(answer.length() <= 2){
            //마지막문자
            String lastCh = answer.substring(answer.length() - 1);
            
            if(answer.length() == 1){
                for(int i = 0; i < 2; i++){
                   answer+=(lastCh); 
                }
            }else if(answer.length() == 2){
                for(int i = 0; i < 1; i++){
                   answer+=(lastCh); 
                }
            }
        }
                
        return answer;
    }
}
