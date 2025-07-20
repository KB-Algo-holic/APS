// PGM 42862 - 체육복
// 유형: 그리디
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42862

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        int[] arr = new int[n + 2];

        //배열을 모두 1로 채우기
        Arrays.fill(arr, 1);

        //체육복을 잃어버린 사람 배열에서 -1
        for(int num : lost){
            arr[num] -= 1;
        }

        //여분의 체육복이 있는사람 배열에서 +1
        for(int num : reserve){
            arr[num] += 1;
        }

        for(int i = 1; i < n+1; i++){
            if(arr[i] == 2){
                //여벌 체육복이 있고, 앞 사람이 체육복이 없는 경우
                if(arr[i-1] == 0){
                    arr[i-1] += 1;
                    arr[i] -= 1;
                    //여벌 체육복이 있고, 뒷 사람이 체육복이 없는 경우
                }else if(arr[i+1] == 0){
                    arr[i+1] += 1;
                    arr[i] -= 1;
                }
            }
        }

        int answer = 0;
        for(int i = 1; i < n+1; i++){
            if(arr[i] > 0){
                answer++;
            }
        }

        return answer;
    }
}