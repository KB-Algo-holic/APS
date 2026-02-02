// PGM 340212 - 퍼즐 게임 챌린지
// 유형: 이진탐색
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/340212

import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int l = 1;
        int r = Integer.MAX_VALUE - 1;

        int temp_level = 1;
        int temp_sum = Integer.MAX_VALUE;
        while(l < r){
            long sum = 0;
            int time_prev = 0;
            int level = (l+r)/2;

            for(int i = 0; i < times.length; i++){
                if(i > 0)
                    time_prev = times[i-1];

                int time_cur = diffs[i] <= level ? times[i] : (times[i] + time_prev) * (diffs[i] - level) + times[i];  //퍼즐 시간계산
                sum += time_cur;
            }

            //이진탐색으로 체크
            if(sum > limit){//퍼즐의 시간이 리미트 초과
                l = level + 1;
            }else{
                if(temp_sum > limit - sum){
                    temp_level = level;
                }
                r = level;
            }
        }
        return temp_level;
    }
}