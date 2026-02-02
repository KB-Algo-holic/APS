// PGM 12923 - 숫자블록
// 유형: 조합
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12923

import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {

        int[] answer = new int[(int)(end-begin+1)];
        Arrays.fill(answer,1);

        int cnt = 0;
        for(long i = begin; i <= end; i++){

            // i의 제곱근까지 약수 탐색 (효율성제한)
            long sqrt = (long)Math.sqrt(i);
            int temp = 0; // 보조 약수 저장 변수

            for(long j = 2; j <= sqrt; j++){
                long num = i/j;

                // j가 i의 약수인 경우
                if(i%j == 0){

                    // 문제조건 1000만 넘으면 안됨
                    if(num > 10000000){
                        temp = (int)j; // 대신 작은 약수 j를 저장
                        continue;
                    }

                    answer[cnt] = (int)(i/j);
                    break;
                }
            }

            // 끝까지 탐색했는데 배정 못했다면 보조 약수(temp) 사용
            if(answer[cnt] == 1 && temp != 0){
                answer[cnt] = temp;
            }
            cnt++;
        }

        // 1인경우 항상 0
        if(begin == 1){
            answer[0] = 0;
        }

        return answer;
    }
}