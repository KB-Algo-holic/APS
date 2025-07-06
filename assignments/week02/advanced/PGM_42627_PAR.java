import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Job> pq = new PriorityQueue<>(), temp;
        
        Arrays.sort(jobs, (o1, o2) -> {
            if(o1[0] == o2[0])
                return Integer.compare(o1[1], o2[1]);
            
            return Integer.compare(o1[0], o2[0]);
        });
        
        pq.offer(new Job(jobs[0][0], jobs[0][1], jobs[0][1], jobs[0][0] + jobs[0][1]));
        
        int idx = 1, curr = pq.peek().curr;
        
        while(!pq.isEmpty()) {
            Job j = pq.poll();
            answer += j.tot;
            curr = j.curr;
            
            temp = pq;
            pq = new PriorityQueue<>();
            
            while(!temp.isEmpty()) {
                Job job = temp.poll();
                pq.offer(new Job(job.req, job.t, job.t + curr - job.req, curr + job.t));
            }
            
            for(; idx < jobs.length; idx++) {
                if(jobs[idx][0] <= curr) {
                    pq.offer(new Job(jobs[idx][0], jobs[idx][1], jobs[idx][1] + curr - jobs[idx][0], curr + jobs[idx][1]));
                }
                else if(pq.isEmpty()) {
                    curr = jobs[idx][0];
                    pq.offer(new Job(jobs[idx][0], jobs[idx][1], jobs[idx][1], jobs[idx][0] + jobs[idx][1]));
                }
                else
                    break;
            }
        }
        
        return answer / jobs.length;
    }
    
    private class Job implements Comparable<Job> {
        int req, t, tot, curr;
        
        public Job(int req, int t, int tot, int curr) {
            this.req = req;
            this.t = t;
            this.tot = tot;
            this.curr = curr;
        }
        
        @Override
        public int compareTo(Job o) {
            return Integer.compare(this.curr, o.curr);
        }
    }
}