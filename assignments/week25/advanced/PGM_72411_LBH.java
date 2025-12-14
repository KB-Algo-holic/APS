// PGM 72411 - 메뉴 리뉴얼
// 해쉬, 조합
// https://school.programmers.co.kr/learn/courses/30/lessons/72411

import java.util.*;

class Solution {

    HashMap<Integer, HashMap<String, Integer>> courseMap = new HashMap<>();

    void putCombinationInMap(String order, String perm, int start, int time, int len) {
        if(time == len) {
            char[] arr = perm.toCharArray();
            Arrays.sort(arr);
            perm = new String(arr);

            courseMap.computeIfAbsent(len, k -> new HashMap<>()).merge(perm, 1, Integer::sum);

            return;
        }

        for(int i = start; i < order.length(); i++) {
            putCombinationInMap(order, perm + order.charAt(i), i + 1, time + 1, len);
        }

        return;
    }

    public String[] solution(String[] orders, int[] course) {

        String order;

        for(int i = 0; i < orders.length; i++) {

            order = orders[i];

            for(int len = 2; len <= order.length(); len++) {
                for(int j = 0; j < course.length; j++) {
                    if(len == course[j]) {
                        putCombinationInMap(order, "", 0, 0, len);
                        break;
                    }
                }
            }
        }

        List<String> answer = new ArrayList<>();

        List<Map.Entry<String, Integer>> list;
        for(int i = 0; i < course.length; i++) {
            if(courseMap.get(course[i]) == null){
                continue;
            }

            list = new ArrayList<>(courseMap.get(course[i]).entrySet());

            if(list.size() > 0) {

                Collections.sort(list, (a, b) -> (b.getValue() - a.getValue()));
                if(list.get(0).getValue() > 1) {
                    answer.add(list.get(0).getKey());
                }
            }

            int lastIdx = 1;
            for(; lastIdx < list.size(); lastIdx++) {
                if(list.get(lastIdx - 1).getValue() == list.get(lastIdx).getValue() && list.get(lastIdx).getValue() > 1) {
                    answer.add(list.get(lastIdx).getKey());
                } else {
                    break;
                }
            }

        }

        Collections.sort(answer, (a, b) -> (a.compareTo(b)));

        return answer.toArray(new String[0]);
    }
}