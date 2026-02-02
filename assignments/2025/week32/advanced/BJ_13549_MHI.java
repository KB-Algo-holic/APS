import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 200001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{n, 0});

        int[] visit = new int[MAX];
        Arrays.fill(visit, 200000);
        visit[n] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int now = cur[0];
            int t = cur[1];

            if (now == k) continue;

            if (now < k) {
                if (now + 1 < MAX && visit[now + 1] > t + 1) {
                    visit[now + 1] = t + 1;
                    queue.add(new int[]{now + 1, t + 1});
                }
                if (now * 2 < MAX && visit[now * 2] > t) {
                    visit[now * 2] = t;
                    queue.add(new int[]{now * 2, t});
                }
            }

            if (now - 1 >= 0 && visit[now - 1] > t + 1) {
                visit[now - 1] = t + 1;
                queue.add(new int[]{now - 1, t + 1});
            }
        }

        System.out.println(visit[k]);
    }
}