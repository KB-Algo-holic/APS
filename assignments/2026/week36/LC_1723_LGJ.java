class Solution {
    int answer = Integer.MAX_VALUE;
    int[] workers; // 작업자의 누적시간
    int[] jobs;
    int n;

    public int minimumTimeRequired(int[] job, int k) {
        // set vars
        workers = new int[k];
        n = job.length;
        jobs = job;

        //System.out.println(Arrays.toString(jobs));
        //System.out.println(Arrays.toString(workers));
        dfs(0, k);
        return answer;
    }

    void dfs(int depth, int k) {

        if (depth == n) {
            int max = 0;
            //System.out.println(Arrays.toString(workers));
            for (int time: workers) {
                if (time > max) {
                    max = time;
                }
            }
            if (max < answer) answer = max;
            return;
        }
        // jobs 분배
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<k; i++) {
            if (!set.add(workers[i])) continue;

            workers[i] += jobs[depth]; // 현재 일감 추가
            if (workers[i] < answer) dfs(depth+1, k);

            // backtracking
            workers[i] -= jobs[depth];
        }
    }
}