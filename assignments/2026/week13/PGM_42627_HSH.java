package week13;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * @param jobs
 *             [0, 3], [1, 9], [2, 6]
 *             현재 시간이 0이기에 먼저 0부터 시작하는데 소요시간이 3 -> 0+3 = 3 현재시간
 *             작업의 반환시간 : 0 + 3 - 0(이전 현재시간) = 3 : 작업의 반환 시간
 * 
 *             다음 소요시간이 적은 [2, 6] 실행
 *             현재시간: 3
 *             소요시간: 6
 *             다음 현재시간: 9
 *             작업 요청시각: 2
 *             반환시간: 9 - 2 = 7
 * 
 *             ... 이런식으로 진행
 * 
 *             따라서 우선 jobs 길이만큼은 돌려야함
 * 
 *             큐에 들어가는건 jobs[j] 만큼 들어가도 될 듯?
 *             대신에.. 현재 시간보다 요청한 시각이 더 적어야함
 *             예를 들어,, 현재시간이 3이면 다음 큐에 들어간 작업의 요청시각이 3보다 작아야 큐가 돌아서 작업을 할거임
 * 
 *             그래놓고도 만약 시간이 뜬다면 (현재시간보다 작업 요청 시간이 더 늦다면) 시간을 그 다음 시간으로 잡아줄 것(현재
 *             시간 = 그 다음 작업의 요청 시간)
 * @return
 */
public class PGM_42627_HSH {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] jobs = {
                { 0, 3 },
                { 1, 9 },
                { 3, 5 }
        };

        int sol = solution(jobs);
        System.out.println(sol);
    }

    public static int solution(int[][] jobs) {
        int totalReturnTime = 0;
        int currentTime = 0;
        int index = 0;
        int completed = 0;

        // 요청 시각 기준 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // 대기 큐: 소요시간 짧은 순 → 요청시각 빠른 순 → 작업번호 작은 순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[2] - b[2];
        });

        while (completed < jobs.length) {

            // 현재 시간까지 요청된 작업을 모두 대기 큐에 넣기
            while (index < jobs.length && jobs[index][0] <= currentTime) {
                pq.offer(new int[] {
                    jobs[index][0], // 요청 시각
                    jobs[index][1], // 소요 시간
                    index           // 작업 번호
                });
                index++;
            }

            // 현재 처리할 수 있는 작업이 없으면 다음 요청 시각으로 이동
            if (pq.isEmpty()) {
                currentTime = jobs[index][0];
                continue;
            }

            // 우선순위가 가장 높은 작업 꺼내기
            int[] currentJob = pq.poll();

            int requestTime = currentJob[0];
            int workTime = currentJob[1];

            // 작업 수행
            currentTime += workTime;

            // 반환 시간 = 완료 시각 - 요청 시각
            totalReturnTime += currentTime - requestTime;

            completed++;
        }

        return totalReturnTime / jobs.length;
	}
}
