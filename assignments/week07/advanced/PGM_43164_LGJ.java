// PGM - 여행경로
// DFS
// https://school.programmers.co.kr/learn/courses/30/lessons/43164
import java.util.*;

class Solution {
    String[] answer = null;

    public String[] solution(String[][] tickets) {
        int n = tickets.length;

        // 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        // 방문배열
        boolean[] used = new boolean[n];
        dfs(tickets, "ICN", new ArrayList<String>(), used);

        return answer;
    }
    public void dfs(String[][] tickets, String cur, List<String> path, boolean[] used) {
        path.add(cur);

        if (path.size() == tickets.length + 1) {
            answer = path.toArray(new String[0]); // 경로 완성
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(cur)) {
                used[i] = true;
                dfs(tickets, tickets[i][1], path, used);
                if (answer != null) return; // 정답 찾았으면 더 탐색 안함
                used[i] = false;
            }
        }

        path.remove(path.size() - 1); // 백트래킹
    }
}