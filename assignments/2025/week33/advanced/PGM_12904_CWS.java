// PGM 12904 - 가장 긴 팰린드롬
// 유형: 문자열
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12904

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        int start = 0;

        while(start < s.length()){

            // 끝점은 문자열 끝부터 시작점 바로 뒤까지 감소
            for(int end = s.length() - 1; end > start; end--){

                // 현재 구간 길이가 이미 구한 최대 길이보다 짧은 경우
                if(end - start + 1 < answer){
                    break;
                }

                // 양 끝 문자가 같을 때만 검사
                if(s.charAt(start) == s.charAt(end)){
                    int left = start;
                    int right = end;

                    while(true){
                        // 포인터가 같거나 교차 직전
                        if(left == right || left + 1 == right){
                            answer = Math.max(answer, end - start + 1);
                            break;
                        }

                        // 내부 문자 비교
                        if(s.charAt(++left) != s.charAt(--right)){
                            break;
                        }
                    }
                }
            }
            start++;
        }

        return answer;
    }
}
