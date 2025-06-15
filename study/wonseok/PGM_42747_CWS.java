// PGM 42747 - H-index
// 유형: 정렬
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42747

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int[] arr = new int[10001];
        for(int i = 0; i < citations.length; i++){
            arr[citations[i]] += 1;
        }
        int temp = citations.length;
        for(int i = 0; i <= citations.length; i++){
            answer = i;
            temp -= arr[i];
            if(temp <= i){
                break;
            }
        }
        return answer;
    }
}