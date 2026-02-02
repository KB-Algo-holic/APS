// PGM 17683 - [3차] 방금그곡
// 유형: 시뮬레이
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17683

import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)"; //기본값
        int min = 0; // 가장 긴 재생 시간

        for(String s : musicinfos){
            String[] music = s.split(","); // 배열정보 나누기

            // 1. 시간 분단위로
            int startTime = Integer.parseInt(music[0].substring(0,2)) * 60 + Integer.parseInt(music[0].substring(3,5));
            int endTime = Integer.parseInt(music[1].substring(0,2)) * 60 + Integer.parseInt(music[1].substring(3,5));
            int musicLength = endTime - startTime;

            // 2. 문자열 생성
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for(int i = 0; i < musicLength; i++){
                sb.append(music[3].charAt(cnt)); // 현재 추가
                // 뒤에 #이 붙으면 하나의 문자로 처리
                if(music[3].charAt(cnt) == '#'){
                    i -= 1;
                }
                cnt++;
                // 끝까지 갔으면 처음으로
                if(cnt == music[3].length()){
                    cnt = 0;
                }
                // 마지막에서 #으로 끝날 경우 처리
                if(i == musicLength - 1){
                    if(music[3].charAt(cnt) == '#'){
                        sb.append(music[3].charAt(cnt));
                    }
                }
            }

            // 3. # 포함 단위로 나누기
            String[] arrSb = new String[sb.length()];
            String[] arrM = new String[m.length()];
            int n = 0;
            for(int i = 0; i < sb.length(); i++){
                if(sb.charAt(i) == '#'){
                    arrSb[n-1] += "#"; // 바로 앞 음에 붙임
                }else{
                    arrSb[n] = sb.charAt(i) + "";
                    n++;
                }
            }
            int sbLength = n; // 실제개수

            // 4. m도 동일하게 처리
            n = 0;
            for(int i = 0; i < m.length(); i++){
                if(m.charAt(i) == '#'){
                    arrM[n-1] += "#";
                }else{
                    arrM[n] = m.charAt(i) + "";
                    n++;
                }
            }
            int mLength = n;

                if(arrSb[i].equals(arrM[0])){
                    for(int j = 0; j < mLength; j++){
                        // 일치하지 않거나 인덱스 초과시 중단
                        if(i+j > sbLength - 1 || !arrSb[i+j].equals(arrM[j])){
                            break;
                        }
                        // 끝까지 일치시 조건 만족
                        if(j == mLength - 1 && musicLength > min){
                            answer = music[2]; // 제목 갱신
                            min = musicLength; // 더 긴 재생 시간으로 갱신
                        }
                    }
                }
            }
        }
        return answer;
    }
}
