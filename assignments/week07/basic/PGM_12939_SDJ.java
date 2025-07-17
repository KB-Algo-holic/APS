# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 12939 - 체육복
# 유형: 그리디
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12939

import java.util.*; 

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        answer = n-lost.length; //도난당하지 않은 사람 수
        
        //도난사람과 여벌옷 있는 사람은 제외처리 후 카운트증가
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        
        //앞뒤 사람에게 체육복을 빌려줄 수 있는 사람은 대여 후 제외
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++){
                if(lost[i] -1 == reserve[j] 
                   || lost[i] +1 == reserve[j]) {
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        return answer;
        
        
    }
}