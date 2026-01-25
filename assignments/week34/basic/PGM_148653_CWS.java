// PGM 148653 - 마법의 엘리베이터
// 유형: 문자열
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/148653

import java.util.*;

class Solution {
    public int solution(int storey) {

        String s = storey + "";
        int[] arr = new int[s.length() + 1];
        int answer = 0;

        // 문자열 → 정수 변환
        for(int i = 1; i <= s.length(); i++){
            arr[i] = s.charAt(i - 1) - '0';
        }
        // 일의 자리부터 가장 높은 자리까지 거꾸로 처리
        for(int i = s.length(); i >= 0; i--){
            // 0~4 ->그냥 내려가는 게 이득
            if(arr[i] < 5){
                answer += arr[i];

                // 정확히 5일 때: 기본은 내려가기, 다음 자리 수가 5 이상이면 올림
            }else if(arr[i] == 5){
                answer += 5;
                if(i != 0)
                    arr[i - 1] = arr[i - 1] > 4 ? arr[i - 1] + 1 : arr[i - 1];
                // 6~9 -> 올려서 10 만드는 게 이득
            }else{
                answer += (10 - arr[i]);

                if(i != 0)
                    arr[i - 1] += 1;
            }
        }

        return answer;
    }
}
