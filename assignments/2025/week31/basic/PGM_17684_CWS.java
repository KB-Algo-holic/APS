// PGM 17684 - 3차[압축]
// 유형: 문자열
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17684

import java.util.*;

class Solution {
    public Integer[] solution(String msg) {
        HashMap<String, Integer> hm = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        // 사전 번호 입력
        int cnt = 1;
        for(char c = 'A'; c <= 'Z'; c++){
            hm.put(c + "", cnt++);
        }
        StringBuilder sb;
        // 전체반복
        for(int i = 0; i < msg.length(); i++){
            sb = new StringBuilder();
            for(int j = i; j < msg.length(); j++){
                sb.append(msg.charAt(j));
                // 사전에 없는 문자열 발견한 경우
                if(hm.get(sb.toString()) == null){
                    // 새 문자열 사전에 추가
                    hm.put(sb.toString(), cnt++);
                    // 직전 문자열의 인덱스 출력
                    list.add(hm.get(sb.substring(0, sb.length() - 1)));
                    // 다음 탐색 시작 위치 조정
                    i = j - 1;
                    break;
                }
                // 문자열 끝까지 도달한 경우
                else if(j == msg.length() - 1){
                    list.add(hm.get(sb.toString()));
                    i = j;
                }
            }
        }
        return list.toArray(new Integer[0]);
    }
}
