// PGM 150370 - 개인정보 수집 유효기간
// 유형: 문자열
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/150370

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> hm = new HashMap<>();
        int year = 12*28;                                // 1년을 '일' 단위로 변환
        List<Integer> list = new ArrayList<>();

        // 오늘 날짜(yyyy.mm.dd) → 총 일수로 변환
        String todayYear = today.substring(0,4);
        String todayMonth = today.substring(5,7);
        String todayDay = today.substring(8,10);

        int todayNum = (Integer.parseInt(todayYear)-2000) * year; // 2000년부터 경과한 '연도' 일수
        todayNum += Integer.parseInt(todayMonth) * 28;            // 월 → 일
        todayNum += Integer.parseInt(todayDay);                   // 일

        // 약관 종류별 유효기간(개월) 저장
        StringTokenizer st;
        for(int i = 0; i < terms.length; i++){
            st = new StringTokenizer(terms[i]);
            String terms1 = st.nextToken();             // 약관명
            String terms2 = st.nextToken();             // 유효기간
            hm.put(terms1, Integer.parseInt(terms2));
        }

        // 각 개인정보별 수집 날짜 + 유효기간 → 만료 날짜 계산
        for(int i = 0; i < privacies.length; i++){
            st = new StringTokenizer(privacies[i]);
            String privacie = st.nextToken();           // 수집 날짜
            String privaciesYear = privacie.substring(0,4);
            String privaciesMonth = privacie.substring(5,7);
            String privaciesDay = privacie.substring(8,10);

            // 수집 날짜를 일수로 변환
            int privacieNum = (Integer.parseInt(privaciesYear) - 2000) * year;
            privacieNum += Integer.parseInt(privaciesMonth) * 28;
            privacieNum += Integer.parseInt(privaciesDay);

            // 유효기간(개월)을 일 단위로 더함
            privacieNum += hm.get(st.nextToken()) * 28;

            // 오늘 날짜가 만료일 이상이면 파기 대상
            if(todayNum >= privacieNum)
                list.add(i+1); // 번호는 1부터 시작
        }

        // 리스트를 배열로 변환
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
