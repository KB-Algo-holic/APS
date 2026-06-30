// PGM 모음 사전 - 84512
// DFS 완전탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/84512


class Solution {
    String[] vowels = {"A", "E", "I", "O", "U"};
    int count = 0;
    int answer = 0;

    public int solution(String word) {
        dfs("", word);
        return answer;
    }

    private void dfs(String current, String target) {
        if (current.equals(target)) {
            answer = count;
            return;
        }

        if (current.length() == 5) {
            return;
        }

        for (String vowel : vowels) {
            count++;
            dfs(current + vowel, target);

            if (answer != 0) {
                return;
            }
        }
    }
}