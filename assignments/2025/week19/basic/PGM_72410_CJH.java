// PGM 72410 - 신규 아이디 추천
// 유형 : 문자열
https://school.programmers.co.kr/learn/courses/30/lessons/72410

public class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^[a-z]|[0-9]|\\-|\\_|\\.]", "");
        new_id = new_id.replaceAll("[\\.]+", ".");
        new_id = new_id.replaceAll("^[\\.]|[\\.]$", "");	        
        new_id = new_id.isEmpty() ? "a" : new_id ;	        
        new_id = new_id.length() > 15 ? new_id.substring(0,15) : new_id ;	        
        new_id = new_id.replaceAll("^[\\.]|[\\.]$", "");	     

        if(new_id.length() <= 2) {
            String plus = new_id.substring(new_id.length()-1);
            while(new_id.length()<3) {
                new_id = new_id+plus;
            }
        };	 

        return new_id;
    }
}
