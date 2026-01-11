// PGM 147354 - 테이블 해시 함수
// 유형: 해시
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/147354

import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        // col번째 컬럼 기준 오름차순, 값이 같다면 첫 번째 컬럼 기준 내림차순
        if(data.length > 1){
            Arrays.sort(data, new Comparator<int[]>(){
                public int compare(int[] a, int[] b){
                    if(a[col - 1] != b[col - 1]){
                        return Integer.compare(a[col - 1], b[col - 1]);
                    }else{
                        return Integer.compare(b[0], a[0]);
                    }
                }
            });
        }

        for(int i = row_begin - 1; i <= row_end - 1; i++){
            int sum = 0;

            // 각 행의 모든 값을 행 번호로 나눈 나머지 합산
            for(int j = 0; j < data[i].length; j++){
                sum += data[i][j] % (i + 1);
            }

            answer ^= sum;
        }

        return answer;
    }
}
