// PGM 12971 - 스티커모으기2
// 유형: 문자열
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12971

import java.util.*;

class Solution {
    public int solution(int sticker[]) {

        int sl = sticker.length;

        // 스티커가 하나인 경우
        if(sl == 1){
            return sticker[0];
        }


        int[] s1 = sticker.clone(); //첫번째 스티커 떼지않는 경우
        int[] s2 = sticker.clone(); //마지막 스티커 떼지않는 경우
        s1[0] = 0;
        s2[sl-1] = 0;

        int[] d1 = new int[sl];
        int[] d2 = new int[sl];

        d1[0] = s1[0];
        d1[1] = s1[1];
        d2[0] = s2[0];
        d2[1] = s2[1];

        //s1 체크
        for(int i = 2; i < sl; i++){
            d1[i] = Math.max(d1[i], s1[i] + d1[i-2]);
            if(i > 2)
                d1[i] = Math.max(d1[i], s1[i] + d1[i-3]);
        }

        //s2 체크
        for(int i = 2; i < sl; i++){
            d2[i] = Math.max(d2[i], s2[i] + d2[i-2]);
            if(i > 2)
                d2[i] = Math.max(d2[i], s2[i] + d2[i-3]);
        }

        // 두 경우 중 최대값 선택
        int answer = 0;
        answer = Math.max(d1[sl-1], d2[sl-1]);
        answer = Math.max(answer, d1[sl-2]);
        answer = Math.max(answer, d2[sl-2]);

        return answer;
    }


}