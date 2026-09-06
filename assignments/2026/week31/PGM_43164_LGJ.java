// PGM 43164 여행경로
// DFS
// https://school.programmers.co.kr/learn/courses/30/lessons/43164


import java.util.*;


class Solution {

    int n;
    String[] answer;
    Map<String, List<String>> connected = new HashMap<>();
    Map<String, boolean[]> visited = new HashMap<>();

    public String[] solution(String[][] tickets) {

        n = tickets.length;
        answer = new String[n+1];

        for (String[] ticket: tickets) {
            // 초기화
            connected.computeIfAbsent(ticket[0], k -> new ArrayList<>()).add(ticket[1]);
        }

        //System.out.println(connected);

        for (String key: connected.keySet()) {
            // 방문 배열 및 오름차순
            List<String> destination = connected.get(key);
            destination.sort((a, b) -> a.compareTo(b));
            visited.put(key, new boolean[destination.size()]);
            //System.out.println(Arrays.toString(visited.get(key)));
        }
        //System.out.println(connected);
        answer[0] = "ICN";
        dfs("ICN", 1);

        return answer;
    }


    private void dfs(String cur, int idx) {

        if (idx == n+1) {
            //System.out.println(Arrays.toString(answer));
            return;
        }

        List<String> nexts = connected.getOrDefault(cur, new ArrayList<>());
        boolean[] visit = visited.get(cur);

        for (int i=0; i<nexts.size(); i++) {
            String next = nexts.get(i);
            if (visit[i]) continue;
            visit[i] = true;
            answer[idx] = next;
            dfs(next, idx+1);
            if (answer[n] != null) return;
            visit[i] = false;
            answer[idx] = null;

        }

        return;

    }
}