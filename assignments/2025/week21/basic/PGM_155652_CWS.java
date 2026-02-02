// PGM 155652 - 둘만의 암호
// 유형: 문자열
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/155652

import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {

        List<Character> list = new ArrayList<>();

        for(char c = 'a'; c <= 'z'; c++){
            boolean t = true;
            // skip 문자면 제외
            for(int i = 0; i < skip.length(); i++){
                if(c == skip.charAt(i)){
                    t = false;
                    break;
                }
            }
            if(t)
                list.add(c); // 사용할 문자만 추가
        }

        String answer = "";

        // s의 각 문자를 순회하면서 index만큼 뒤로 이동한 문자로 변환
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < list.size(); j++){
                if(s.charAt(i) == list.get(j)){
                    // (j + index)가 리스트 범위를 넘어가면 순환하도록 처리
                    answer += list.get((j + index) % list.size());
                }
            }
        }

        return answer;
    }


}