# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 135808 - 과일 장수
# 유형: 연습문제
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/135808
# 해설: 최대의 이익을 남기기 위해 높은 점수의 사과만 상자에 담아주고 각 상자별 가장 낮은 점수로 계산하여 상자의 값을 정합니다.
## 세부 로직:
	1. 사과배열을 점수별로 오름차순 정렬합니다.
	2. 반복문을 통해 m개씩 들어가는 상자들 중에 가장 작은점수(상자별 가장 첫번째 사과)의 점수와 사과의 갯수를 곱한 것을 answer에 넣어줍니다.
	3. 위 로직을 통해 최종적으로 합산된 answer값이 총이익으로 리턴됩니다.
    
import java.util.*;

class Solution { 
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        for(int idx=score.length; idx>=m; idx-=m){
            int row = score[idx-m];
            answer = answer + (row * m);
        }
        
        return answer;
    }
}