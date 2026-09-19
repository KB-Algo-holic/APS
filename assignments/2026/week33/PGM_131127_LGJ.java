// PGM 131127 할인 행사
// 슬라이딩 윈도우
// https://school.programmers.co.kr/learn/courses/30/lessons/131127?language=java


import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> buckets = new HashMap<String, Integer>();
        for (int i=0; i<want.length; i++) {
            buckets.put(want[i], number[i]);
        }
        int n = discount.length;

        Map<String, Integer> sales = new HashMap<String, Integer>();

        for (int i=0; i<10; i++) {
            String goods = discount[i];
            sales.put(goods, sales.getOrDefault(goods, 0)+1);
        }
        boolean isPossible = true;
        for (String key: buckets.keySet()) {
            if (buckets.get(key) != sales.getOrDefault(key, 0)) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) answer ++;

        for (int i=1; i<n-9; i++) {
            String cur = discount[i-1]; //삭제
            String cur2 = discount[i+9]; //추가
            sales.put(cur, sales.get(cur)-1);
            sales.put(cur2, sales.getOrDefault(cur2, 0)+1);
            isPossible = true;
            for (String key: buckets.keySet()) {
                if (buckets.get(key) != sales.getOrDefault(key, 0)) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) answer ++;

        }



        return answer;
    }
}