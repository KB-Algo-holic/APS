// PGM 134239 - 우박수열 정적분
// 시뮬레이션
// https://school.programmers.co.kr/learn/courses/30/lessons/134239

import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {

        List<Double> list = new ArrayList<>();

        //콜라츠 추측
        while(k != 1){
            int n = k;
            if(k % 2 == 0) k /= 2;
            else k = k*3+1;
            //넓이 리스트에 저장
            list.add((double)(n + k)/2);
        }

        double[] answer = new double[ranges.length];

        int cnt = 0;
        for(int i = 0; i < ranges.length; i++){
            //-1을 넣기위해 조건추가
            if(list.size() + ranges[i][1] < ranges[i][0]){
                answer[cnt] = -1;
            }else{
                for(int j = ranges[i][0]; j < list.size() + ranges[i][1]; j++){
                    answer[cnt] += (double)list.get(j);
                }
            }
            cnt++;
        }


        return answer;
    }
}