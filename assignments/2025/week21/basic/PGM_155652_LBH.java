// PGM 155652 - 둘만의 암호
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/155652

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            for(int j = 0; j < index; j++){

                if(temp != 'z'){
                    temp = temp + 2;
                } else {
                    temp = 'a';
                }

                for(int k = 0; k < skip.length(); k++){
                    if(temp == skip.charAt(k)){
                        j--; break;
                    }
                }
            }

            answer += temp;
        }

        return answer;
    }
}