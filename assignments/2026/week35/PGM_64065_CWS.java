// PGM 64066 - 튜플
// 문자열
// https://school.programmers.co.kr/learn/courses/30/lessons/64065

import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] sets = s.substring(2, s.length() - 2).split("\\},\\{");
        int n = sets.length;

        String[][] arr = new String[n + 1][];
        for (String set : sets) {
            String[] nums = set.split(",");
            arr[nums.length] = nums;
        }

        HashSet<String> hs = new HashSet<>();
        int[] answer = new int[n];

        for (int i = 1; i <= n; i++) {
            for (String x : arr[i]) {
                if (hs.add(x)) {
                    answer[i-1] = Integer.parseInt(x);
                    break;
                }
            }
        }
        return answer;
    }
}