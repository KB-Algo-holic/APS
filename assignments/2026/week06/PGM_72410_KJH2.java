// PGM-72410 신규 아이디 추천
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/72410

class Solution {
    
    public String solution(String new_id){
        StringBuilder sb = new StringBuilder();
        // 1단계
        String chk_id = new_id.toLowerCase();
        
        //2단계
        for(int i = 0; i < chk_id.length(); i ++){
            char ch = chk_id.charAt(i);
            if(ch >= 'a' && ch <= 'z' || ch >= '0' && ch <='9' 
               || ch == '-' || ch == '.' || ch == '_'){
               sb.append(ch); 
            }
        }
        // 5단계
        if(sb.length() == 0)
            sb.append('a');
        // 3단계
        StringBuilder sb2 = new StringBuilder();
        // 제거할 문자
        char dot = '.';
        // 비교할 문자
        char ch1 = ' ';
        // 직전문자
        char ch2 = ' ';
        for(int i = 0; i < sb.length(); i ++){
            ch1 = sb.charAt(i);
            if(ch1 == dot && ch1 == ch2)
                continue;
            else{
                sb2.append(ch1);
                ch2 = ch1;
            }
        }
        // 4단계
        if(sb2.charAt(0) == '.')
            sb2.delete(0,1);
        if(sb2.length() != 0 && sb2.charAt(sb2.length() - 1 ) == '.')
            sb2.delete(sb2.length() - 1, sb2.length());
        // 5단계
        if(sb2.length() == 0)
            sb2.append('a');
        // 6단계
        if(sb2.length() > 15){
            sb2.delete(15, sb2.length());
            if(sb2.charAt(sb2.length() - 1) == '.')
                sb2.delete(sb2.length() - 1, sb2.length());
        }
        // 7단계
        while(sb2.length() < 3){
            sb2.append(sb2.charAt(sb2.length() - 1));
        }
        chk_id = sb2.toString();
        return chk_id;
    }
    
    
    /* 정규식
    public String solution(String new_id) {
        // 1단계
        String chk_id = new_id.toLowerCase();
        // 2단계
        chk_id = chk_id.replaceAll("[^a-z0-9\\-_\\.]","");
        // 3단계
        chk_id = chk_id.replaceAll("\\.{2,}", ".");
        // 4단계
        chk_id = chk_id.replaceAll("^\\.|\\.$","");
        // 5단계
        if(chk_id.equals(""))
            chk_id = "a";
        // 6단계
        if(chk_id.length() > 15){
            chk_id = chk_id.substring(0,15);
            chk_id = chk_id.replaceAll("\\.$", "");
        }
        // 7단계
        if(chk_id.length() < 3){
            StringBuilder sb = new StringBuilder(chk_id);
            while(sb.length() < 3){
                sb.insert(sb.length(), sb.charAt(sb.length() - 1));
            }
            chk_id = sb.toString();
        }
        return chk_id;
    }
  */
}
