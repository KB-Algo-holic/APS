// PGM 43162 - 네트워크
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/43162

import java.util.Stack;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        
        // 모든 컴퓨터를 순회
        for (int i = 0; i < n; i++) {
            // 아직 방문하지 않은 컴퓨터라면 새로운 네트워크 시작
            if (!visited[i]) {
                answer++; // 네트워크 개수 추가
                
                // DFS 시작: 현재 컴퓨터를 스택에 넣고 방문 처리
                stack.push(i);
                visited[i] = true;
                
                // 스택이 빌 때까지 연결된 모든 컴퓨터 탐색
                while (!stack.isEmpty()) {
                    int current = stack.pop();
                    
                    for (int j = 0; j < n; j++) {
                        // 연결되어 있고, 아직 방문하지 않은 다른 컴퓨터가 있다면
                        if (computers[current][j] == 1 && !visited[j]) {
                            stack.push(j);
                            visited[j] = true; // 스택에 넣을 때 방문 처리
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}
