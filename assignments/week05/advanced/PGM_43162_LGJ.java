// PGM 43162 - 네트워크
// 유형: DFS
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43162

import java.util.Stack;

class Solution {
    public int solution(int n, int[][] computers) {
        int networkCount = 0;
        boolean[] visited = new boolean[n];

        // 모든 컴퓨터를 순회하며 아직 방문하지 않은 컴퓨터를 시작점으로 네트워크 탐색
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                networkCount++;
                // 해당 컴퓨터부터 연결된 모든 컴퓨터를 탐색 (DFS)
                exploreNetwork(i, n, computers, visited);
            }
        }

        return networkCount; // 최종 네트워크 개수 반환
    }

    private void exploreNetwork(int startNode, int n, int[][] computers, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();

        // 시작 노드를 스택에 추가하고 방문 처리
        stack.push(startNode);
        visited[startNode] = true;

        // 스택이 빌 때까지 반복 (DFS 탐색)
        while (!stack.isEmpty()) {
            int currentNode = stack.pop(); // 현재 탐색할 컴퓨터

            // 현재 컴퓨터와 연결된 모든 다른 컴퓨터들을 확인
            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (currentNode != nextNode && computers[currentNode][nextNode] == 1 && !visited[nextNode]) {
                    visited[nextNode] = true; // 다음 컴퓨터 방문 처리
                    stack.push(nextNode);     // 스택에 추가하여 나중에 탐색
                }
            }
        }
    }
}