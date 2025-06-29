# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 172927 - 광물캐기
# 유형: 그리디
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/172927

import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int maxCnt = 5;
        
        int diaCnt = picks[0] * maxCnt;
        int ironCnt = picks[1] * maxCnt;
        int stoneCnt = picks[2] * maxCnt;
        
        for(String tempStr : minerals) {
            if("diamond".equals(tempStr)) {
                if(diaCnt > 0) {
                    diaCnt--;
                    answer = answer + 1;
                }else if(ironCnt > 0) {
                    ironCnt--;
                    answer = answer + 5;
                }else if(stoneCnt > 0) {
                    stoneCnt--;
                    answer = answer + 25;
                }
                    
            }
            else if("iron".equals(tempStr)) {
                if(diaCnt > 0) {
                    diaCnt--;
                    answer = answer + 1;
                }else if(ironCnt > 0) {
                    ironCnt--;
                    answer = answer + 1;
                }else if(stoneCnt > 0) {
                    stoneCnt--;
                    answer = answer + 5;
                }
            }else if("stone".equals(tempStr)) {
                if(diaCnt > 0) {
                    diaCnt--;
                    answer = answer + 1;

                }else if(ironCnt > 0) {
                    ironCnt--;
                    answer = answer + 1;

                }else if(stoneCnt > 0) {
                    stoneCnt--;
                    answer = answer + 1;

                }
                
            }
        }        
        return answer;
    }
}