// PGM 72410 - 문자열 밀기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/72410
class Solution {
    public String solution(String new_id) {


        String answer = "";
//        String charA = "";
//        int size = new_id.length();       

        /* 
         * 정규식으로 다시 풀어본 소스 
         */
        // 1단계 소문자로 변경
        answer = new_id.toLowerCase();
        
        // 2단계 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자를 제거
        answer = answer.replaceAll("[^a-z0-9._-]", "");

        // 3단계 .. 2개 이상이면 .으로 변경
        answer = answer.replaceAll("[.]{2,}", ".");

        // 4단계 .이 처음이나 끝이면 지우기
        answer = answer.replaceAll("^[.]|[.]$", "");

        // 5단계 빈문자열 a 반환
        if(answer.equals("")) answer = "a";

        // 6단계 16자 이상이면 15자로, 15자로변경시 마지막이 .이면 삭제
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }

        // 7단계 길이가 2이하이면 마지막 문자를 길이가 3될때까지 반복
        if(answer.length() <= 2) {
            String lastChar = answer.substring(answer.length()-1);
            answer = answer + lastChar.repeat(3-answer.length());
        }

        /*
         * 내 풀이소스
         */
        // 1단계 소문자로 변경
//        answer = new_id.toLowerCase();        
//        for(int i = 0; i < size; i++) {
//            charA = new_id.substring(i, i+1);

//            // 2단계 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자를 제거
//            if(!(charA.hashCode() >= 97 && charA.hashCode() <= 122
//                    || charA.hashCode() >= 48 && charA.hashCode() <= 57
//                    || charA.hashCode() == 45
//                    || charA.hashCode() == 95
//                    || charA.hashCode() == 46
//              )) {
//                charA = "";
//            }
      
//            answer = answer + charA;
//            // 3단계 .. 2개 이상이면 .으로 변경
//            answer = answer.replace("..", ".");
//        }
      
//        // 4단계 .이 처음이나 끝이면 지우기
//        System.out.println("answer. :" + answer);
//        answer = answer.replaceAll("^\.+|\.+$", "");
//        System.out.println("answer.. :" + answer);
//        int tempSize = answer.length();

//        // 5단계 빈문자열 a 반환
//        if(tempSize == 0) answer = "a";

//        // 6단계 16자 이상이면 15자로, 15자로변경시 마지막이 .이면 삭제
//        if(tempSize >= 16) {
//            System.out.println("answer1 :" + answer);
//            answer = answer.substring(0, 15);
//            System.out.println("answer2 :" + answer);
//            answer = answer.replaceAll("\.+$", "");
//            System.out.println("answer3 :" + answer);
//        }

//        // 7단계 길이가 2이하이면 마지막 문자를 길이가 3될때까지 반복
//        tempSize = answer.length();
//        if(tempSize <= 2) {
//            String lastChar = answer.substring(tempSize-1);
//            //answer = answer + lastChar.repeat(3-tempSize);
//            answer = answer + lastChar;
//            System.out.println("answer4 :" + answer);
//        }
        return answer;
    }
}
