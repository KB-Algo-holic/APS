// PGM 17677 - 뉴스 클러스터링
// 시뮬레이션
// https://school.programmers.co.kr/learn/courses/30/lessons/17677

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {

        // 알파벳 판별용 배열
        char[] alp = new char[52];
        int cnt = 0;

        for(char c = 'a'; c <= 'z'; c++){
            alp[cnt++] = c;
        }
        for(char c = 'A'; c <= 'Z'; c++){
            alp[cnt++] = c;
        }

        // 두 글자씩 묶기
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // 다중집합 저장 리스트
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for(int i = 0; i < str1.length(); i++){
            boolean t = false; // 현재 문자가 알파벳인지 여부

            // 알파벳인지 확인
            for(int j = 0; j < 52; j++){
                if(str1.charAt(i) == alp[j]){
                    t = true;

                    sb1.append(alp[j]);

                    // 길이 2가 되면 하나의 원소 완성
                    if(sb1.length() == 2){
                        list1.add(sb1.toString().toUpperCase());
                        sb1.deleteCharAt(0);
                    }
                    continue;
                }
            }

            // 알파벳이 아니면 연속성 깨짐 → 초기화
            if(!t) sb1.setLength(0);
        }

        for(int i = 0; i < str2.length(); i++){
            boolean t = false;

            for(int j = 0; j < 52; j++){
                if(str2.charAt(i) == alp[j]){
                    t = true;

                    sb2.append(alp[j]);

                    if(sb2.length() == 2){
                        list2.add(sb2.toString().toUpperCase());
                        sb2.deleteCharAt(0);
                    }
                    continue;
                }
            }

            if(!t) sb2.setLength(0);
        }

        double n1 = 0;
        double n2 = list1.size() + list2.size();

        // list2 기준으로 계산
        for(int i = 0; i < list2.size(); i++){
            if(list1.contains(list2.get(i))){
                list1.remove(list2.get(i));
                n1++;
                n2--;
            }
        }

        // 둘 다 공집합이면 1 * 65536
        if(n2 == 0){
            return 65536;
        }else{
            return (int)Math.floor(n1 / n2 * 65536);
        }
    }
}
