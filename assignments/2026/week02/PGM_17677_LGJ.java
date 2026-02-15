// PGM - 17677
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/17677


import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0; //곱하기 65536 정수
        // 전처리
        // 1) to upper case
        String upper1 = str1.toUpperCase();
        String upper2 = str2.toUpperCase();

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i=0; i<upper1.length(); i++) {
            StringBuilder sb = new StringBuilder();
            char ch = upper1.charAt(i);
            if (i == 0) continue;
            char before_ch = upper1.charAt(i-1);

            if (Character.isAlphabetic(ch) && Character.isAlphabetic(before_ch)) {
                sb.append(before_ch);
                sb.append(ch);
                int cnt = map1.getOrDefault(sb.toString(), 0);
                map1.put(sb.toString(), cnt+1);
                //System.out.println(sb.toString());
            }
        }

        for (int i=0; i<upper2.length(); i++) {
            StringBuilder sb = new StringBuilder();
            char ch = upper2.charAt(i);
            if (i == 0) continue;
            char before_ch = upper2.charAt(i-1);

            if (Character.isAlphabetic(ch) && Character.isAlphabetic(before_ch)) {
                sb.append(before_ch);
                sb.append(ch);
                int cnt = map2.getOrDefault(sb.toString(), 0);
                map2.put(sb.toString(), cnt+1);
                //System.out.println(sb.toString());
            }
        }

        //System.out.println(map1);
        //System.out.println(map2);

        Set<String> set1 = map1.keySet();
        Set<String> set2 = map2.keySet();
        if (set1.isEmpty() && set2.isEmpty()) return 65536;
        int min = 0;
        int max = 0;
        for (String s: set1) {
//            System.out.println(s);
            int cnt1 = map1.get(s);
            int cnt2 = map2.getOrDefault(s, 0);
            if (cnt2 == 0) {
                // 합집합 - str1만 존재
                max += cnt1;
                continue;
            }
            // 교집합
            min += Math.min(cnt1, cnt2);
            max += Math.max(cnt1, cnt2);
        }
        for (String s: set2) {
//            System.out.println(s);
            int cnt1 = map1.getOrDefault(s, 0);
            int cnt2 = map2.get(s);
            if (cnt1 == 0) {
                // 합집합 - str1만 존재
                max += cnt2;
            }
        }
        //System.out.println(min);
        //System.out.println(max);

        double tmp = (double) min / max * 65536;
        answer = (int) tmp;
        //System.out.println(answer);
        return answer;
    }
}