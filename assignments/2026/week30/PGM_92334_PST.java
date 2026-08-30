// PGM 92334 - 신고 결과 받기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/92334?language=java

import java.util.*;

public class PGM_92334_PST {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));

        Map<String, Integer> reportedCountMap = new HashMap<>();

        Map<String, List<String>> userReportMap = new HashMap<>();

        for (String rep : reportSet) {
            String[] parts = rep.split(" ");
            String reporter = parts[0]; // 신고한 유저
            String reported = parts[1]; // 신고당한 유저

            reportedCountMap.put(reported, reportedCountMap.getOrDefault(reported, 0) + 1);

            userReportMap.computeIfAbsent(reporter, key -> new ArrayList<>()).add(reported);
        }

        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            List<String> targetList = userReportMap.get(user);

            if (targetList != null) {
                for (String target : targetList) {
                    if (reportedCountMap.getOrDefault(target, 0) >= k) {
                        answer[i]++;
                    }
                }
            }
        }

        return answer;
    }
}
