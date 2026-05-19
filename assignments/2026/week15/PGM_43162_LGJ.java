// PGM 43162 - 네트워크 풀이완료
// DFS > Union Find 방식 재풀이 필요
// https://school.programmers.co.kr/learn/courses/30/lessons/43162


import java.util.*;


class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(i, computers, n, visited);
                answer ++;
            }

        }

        return answer;
    }
    private void dfs(int node, int[][] computers, int n, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited[node] = true;

        while(!stack.isEmpty()) {
            int cur = stack.pop();

            for (int next=0; next<n; next++) {
                if (cur != next && computers[cur][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    stack.push(next);
                }
            }
        }

    }

}