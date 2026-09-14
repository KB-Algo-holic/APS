// PGM 42577 전화번호 목록
// 해시
// https://school.programmers.co.kr/learn/courses/30/lessons/42577
// Map이 아닌 Set으로 해결


import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book, (a, b) -> a.length() - b.length());

        int n = phone_book.length;
        int min = phone_book[0].length();

        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            String number = phone_book[i];
            int len = number.length();

            for (int l=min; l<len; l++) {
                String temp = number.substring(0, l);
                //System.out.println(temp);
                int result = map.getOrDefault(temp, 0);
                if (result == 1) return false;
            }

            map.put(number, 1);

        }

        return answer;
    }
}