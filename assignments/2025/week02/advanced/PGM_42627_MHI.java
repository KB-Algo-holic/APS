import java.util.*;
class Solution {
    public int solution(int[][] jobs) {

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int time = 0;
        int currentJob = 0;
        int answer = 0;
        int i = 0;

        while (true) {

            while (i < jobs.length && jobs[i][0] == time) {
                que.add(jobs[i]);
                i ++;
            }

            if (currentJob <= 0) {
                if (!que.isEmpty()) {
                    currentJob = que.poll()[1];
                    answer += currentJob;
                } else if (i == jobs.length) {
                    break;
                }
            }

            answer += que.size();

            currentJob --;
            time ++;
        }

        return answer / jobs.length;
    }
}