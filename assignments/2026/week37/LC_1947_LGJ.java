// LC 1947 - Maximum Compatibility Score Sum
// 완전탐색
// https://leetcode.com/problems/maximum-score-words-formed-by-letters/


import java.util.Arrays;

class Solution {
    private int maxScore;
    private boolean[] mentorAssigned;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        
        // 각 테스트 케이스마다 독립성을 보장하기 위해 메서드 내부에서 초기화
        this.maxScore = 0;
        this.mentorAssigned = new boolean[m];
        
        // 미리 학생과 멘토 간의 호환성 점수를 계산해두면(Pre-computation) 더 빨라집니다.
        int[][] scoreMatrix = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                scoreMatrix[i][j] = getCompatibilityScore(students[i], mentors[j]);
            }
        }

        // DFS 탐색 시작 (0번 학생부터 시작, 현재 누적 점수 0)
        dfs(0, m, 0, scoreMatrix);
        
        return maxScore;
    }

    private void dfs(int studentIdx, int m, int currentScore, int[][] scoreMatrix) {
        // 모든 학생의 매칭이 완료된 경우
        if (studentIdx == m) {
            maxScore = Math.max(maxScore, currentScore);
            return;
        }

        // 현재 학생(studentIdx)에게 배정할 멘토(i)를 탐색
        for (int i = 0; i < m; i++) {
            if (mentorAssigned[i]) continue;

            mentorAssigned[i] = true;
            // 다음 학생으로 넘어가면서 현재 매칭된 점수를 바로 누적하여 전달
            dfs(studentIdx + 1, m, currentScore + scoreMatrix[studentIdx][i], scoreMatrix);
            mentorAssigned[i] = false; // 백트래킹 (원상복구)
        }
    }

    // 두 배열 간의 일치하는 원소 개수 계산
    private int getCompatibilityScore(int[] student, int[] mentor) {
        int score = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i] == mentor[i]) {
                score++;
            }
        }
        return score;
    }
}
