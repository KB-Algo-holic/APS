// PGM 131127 - 할인행사
// 투포인터/슬라이딩윈도우
// https://school.programmers.co.kr/learn/courses/30/lessons/131127

import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int[] arr = new int[want.length];

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < want.length; j++){
                if(discount[i].equals(want[j])){
                    arr[j]++;
                    continue;
                }
            }
        }
        if(Arrays.equals(arr, number)) answer++;

        for(int i = 10; i < discount.length; i++){
            for(int j = 0; j < want.length; j++){
                if(discount[i].equals(want[j])){
                    ++arr[j];
                }
                if(discount[i-10].equals(want[j])){
                    --arr[j];
                }

            }
            if(Arrays.equals(arr, number)) {
                answer++;
            }
        }

        return answer;
    }
}