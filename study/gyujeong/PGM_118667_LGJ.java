import java.util.*;
public class PGM_118667_LGJ {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        long q1Total = 0;
        long q2Total = 0;
        Deque<Integer> dq1 = new ArrayDeque<>();
        Deque<Integer> dq2 = new ArrayDeque<>();

        for (int i=0; i<queue1.length; i++) {
            int n1 = queue1[i];
            int n2 = queue2[i];
            dq1.offer(n1);
            dq2.offer(n2);
            q1Total += n1;
            q2Total += n2;
        }
        long target = (q1Total+q2Total) / 2;
        int cnt = 0;
        while (true) {
            if (q1Total == q2Total) return cnt;
            if (cnt > queue1.length*3) break;

            if (q1Total > q2Total) {
                int temp = dq1.poll();
                q1Total -= temp;
                q2Total += temp;
                dq2.offer(temp);
            } else {
                int temp = dq2.poll();
                q2Total -= temp;
                q1Total += temp;
                dq1.offer(temp);
            }

            cnt ++;
        }

        return answer;
    }
}
