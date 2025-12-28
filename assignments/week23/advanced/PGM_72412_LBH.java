// PGM 72412 - 순위 검색
// 해쉬
// https://school.programmers.co.kr/learn/courses/30/lessons/72412

import java.util.*;

class Solution {

    Map<String, List<Integer>> map = new HashMap<>();

    int lowerBound(List<Integer> list, int key) {

        int left = 0; int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    void enroll(String[] info, int index, int time, int max, String key, int score) {

        if (time == max) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }

        for (int i = index; i < 4; i++) {
            enroll(info, i + 1, time + 1, max, key + info[i], score);
        }

    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // hash
        String[] temp;
        for (int i = 0; i < info.length; i++) {
            temp = info[i].split(" ");
            int score = Integer.parseInt(temp[4]);

            for (int j = 0; j <= 4; j++) {
                enroll(temp, 0, 0, j, "", score);
            }
        }

        // sort
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }

        // query
        for (int i = 0; i < query.length; i++) {
            temp = query[i].split(" ");

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < temp.length - 1; j++) {
                if (!temp[j].equals("-") && !temp[j].equals("and")) {
                    sb.append(temp[j]);
                }
            }
            String key = sb.toString();

            if (map.containsKey(key)) {
                List<Integer> scores = map.get(key);
                int target = Integer.parseInt(temp[temp.length - 1]);
                int idx = lowerBound(scores, target);

                answer[i] = scores.size() - idx;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }
}
