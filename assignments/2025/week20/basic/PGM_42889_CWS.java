// PGM 42889 - 실패율
// 유형: 정렬
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42889

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {

        double[][] arr = new double[N][2];

        for(int i = 0; i < stages.length; i++){
            if(stages[i] == N + 1){ // 모든 스테이지클리어
                for(int j = 0; j < stages[i]-1; j++){
                    arr[j][0] += 1; // 스테이지 도달
                }
            }else{
                for(int j = 0; j < stages[i]; j++){
                    arr[j][0] += 1; // 스테이지 도달
                }
                arr[stages[i]-1][1] += 1; // 실패 인원 카운트
            }
        }

        // 각 스테이지의 실패율 계산
        for(int i = 0; i < arr.length; i++){
            // 실패율
            arr[i][1] = Double.isNaN(arr[i][1]/arr[i][0]) ? 0.0 : arr[i][1]/arr[i][0]; //0으로 나눌 경우 0으로 처리
            arr[i][0] = i; // 인덱스저장
        }

        // 실패율을 기준으로 정렬
        Arrays.sort(arr, new Comparator<double[]>(){
            public int compare(double[] a, double[] b){
                // 실패율이 다르면 실패율이 높은 순으로 정렬
                if(a[1] != b[1]){
                    return Double.compare(a[1], b[1]);
                }else{
                    // 실패율이 같으면 스테이지 번호가 낮은 순으로 정렬
                    return Double.compare(b[0], a[0]);
                }
            }
        });

        int[] answer = new int[N];
        int cnt = N;
        for(int i = 0; i < N; i++){
            answer[--cnt] = (int)arr[i][0] + 1;
        }
        return answer;
    }


}