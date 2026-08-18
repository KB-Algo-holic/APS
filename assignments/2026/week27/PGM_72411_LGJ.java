// 모의고사
// PGM - 72411 메뉴리뉴얼
// 완전탐색 - 조합
// https://school.programmers.co.kr/learn/courses/30/lessons/72411


import java.util.*;

class Solution {

    Map<String, Integer> comb_cnt = new HashMap<>();
    Map<Integer, Integer> max_cnt = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        // 조합 별 cnt
        for (String order: orders) {
            // 1. 문자열을 char 배열로 변환
            char[] chars = order.toCharArray();
            // 2. 알파벳 순으로 오름차순 정렬
            Arrays.sort(chars);
            // 3. 정렬된 배열을 다시 String으로 변환
            String sortedOrder = new String(chars);

            for (int n: course) {
                comb(n, 0, "", sortedOrder);
            }
        }

        System.out.println(comb_cnt);
        //System.out.println(max_cnt);

        List<String> temp = new ArrayList<>();
        for (int cnt: course) {
            int maxCnt = max_cnt.getOrDefault(cnt, 0);
            if (maxCnt == 0) continue;

            for (Map.Entry<String, Integer> entry: comb_cnt.entrySet()) {
                if (entry.getKey().length() != cnt) continue;
                if (entry.getValue() != maxCnt) continue;
                if (entry.getValue() < 2) continue;

                temp.add(entry.getKey());
            }

        }

        //System.out.println(temp);
        String[] answer = new String[temp.size()];
        for (int i=0; i<temp.size(); i++) {
            answer[i] = temp.get(i);
        }

        Arrays.sort(answer, (a, b) -> a.compareTo(b));
        return answer;
    }

    void comb(int n, int idx, String cur, String order) {

        if (cur.length() == n) {
            //System.out.println(cur);
            // cnt 추가
            comb_cnt.put(cur, comb_cnt.getOrDefault(cur, 0)+1);
            max_cnt.put(n, Math.max(max_cnt.getOrDefault(n, 0), comb_cnt.get(cur)));

            return;
        }

        for (int i=idx; i<order.length(); i++) {
            comb(n, i+1, cur + order.substring(i, i+1), order);
            //cur = order.substring(0, order.length()-1);
        }

    }
}