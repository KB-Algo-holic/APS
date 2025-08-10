// PGM 150370 - 개인정보 수집 유효기간
// 유형 : 문자열
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/150370

import java.util.*;

public class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> termMap = new HashMap<>();
        
        for(String term : terms) {
            termMap.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }
        
        for(int i=0; i<privacies.length; i++) {
            String p[] = privacies[i].split(" ");
            int year = Integer.parseInt(today.split("\\.")[0]) - Integer.parseInt(p[0].split("\\.")[0]);
            int month = Integer.parseInt(today.split("\\.")[1]) - Integer.parseInt(p[0].split("\\.")[1]);
            int day = Integer.parseInt(today.split("\\.")[2]) - Integer.parseInt(p[0].split("\\.")[2]);
            int term = termMap.get(p[1]) * 28;
            int sum = year*12*28 + month*28 + day;
            
            if (sum >= term) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(integer -> integer).toArray();
    }
}