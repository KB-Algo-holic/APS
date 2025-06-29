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