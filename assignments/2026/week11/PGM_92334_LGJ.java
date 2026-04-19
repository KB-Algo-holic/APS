// PGM 92334 - 신고 결과 받기
// 해쉬
// https://school.programmers.co.kr/learn/courses/30/lessons/92334


import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        // 유저별 신고한 ID
        HashMap<String, Set<String>> reportTo = new HashMap<>();

        // 유저별 신고받은 ID
        HashMap<String, Set<String>> reportFrom = new HashMap<>();

        for (String id: id_list) {
            reportTo.put(id, new HashSet<>());
            reportFrom.put(id, new HashSet<>());
        }

        for (String r: report) {
            String[] fromTo = r.split(" "); // [0] from [1] to
            reportTo.get(fromTo[0]).add(fromTo[1]);
            reportFrom.get(fromTo[1]).add(fromTo[0]);
        }

        // System.out.println(reportTo);
        // System.out.println(reportFrom);

        for (int i=0; i<n; i++) {
            String user = id_list[i];
            for (String target: reportTo.get(user)) {
                if (reportFrom.get(target).size() >= k) {
                    answer[i] += 1;
                }
            }

        }

        return answer;
    }
}