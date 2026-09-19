// LC 526 Beautiful Arrangement
// 완전탐색(순열, 백트래킹)
// https://leetcode.com/problems/beautiful-arrangement/description/

class Solution {

    boolean[] visited;
    int answer = 0;

    public int countArrangement(int n) {

        visited = new boolean[n + 1];

        perm(n, 0);

        return answer;
    }

    private void perm(int n, int idx) {

        if (idx == n) {
            answer++;
            return;
        }

        int position = idx + 1;

        for (int num = 1; num <= n; num++) {

            if (visited[num]) continue;

            // 이 위치에 num을 놓을 수 있는가?
            if (num % position != 0 &&
                    position % num != 0) {
                continue;
            }

            visited[num] = true;

            perm(n, idx + 1);

            visited[num] = false;
        }
    }
}