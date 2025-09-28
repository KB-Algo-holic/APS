// PGM 17681 - [1차]-비밀지도
// 유형: 문자열
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17681

import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            sb = new StringBuilder();

            // 2진수 문자열로 변환, n자리 맞춰서 앞에 0 채움
            String s1 = String.format("%0"+n+"d", Long.parseLong(Long.toString(arr1[i],2)));
            String s2 = String.format("%0"+n+"d", Long.parseLong(Long.toString(arr2[i],2)));

            // 하나라도 1이면 # 처리
            for(int j = 0; j < n; j++){
                if(s1.charAt(j) == '1' || s2.charAt(j) == '1'){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString(); // 한줄 완성시
        }

        return answer;
    }
}
