// PGM 87946 - 피로도
// 완전탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/87946

class Solution {
    boolean[] visited;
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        makeAns(k, dungeons, 0);
        return answer;
    }

    public void makeAns(int stress, int[][] dungeons, int count) {
        answer = Math.max(answer, count);

        for (int i=0; i< visited.length; i++) {
            if (!visited[i] && dungeons[i][0] <= stress) {
                visited[i] = true;
                makeAns(stress - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }
    }
}