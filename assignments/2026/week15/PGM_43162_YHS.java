// PGM - 43162 L3_네트워크
// BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/43162
import java.util.LinkedList;
import java.util.Queue;

public class PGM_43162_YHS {
    boolean[] isVisited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                System.out.println();
                answer++;
                bfs(i, computers);
            }
        }
        return answer;
    }

    void bfs(int cur, int[][] map) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        isVisited[cur] = true;

        while (!queue.isEmpty()) {
            int front = queue.poll();
            int[] childs = map[front];
            for (int i = 0; i < childs.length; i++) {
                int child = childs[i];
                if (!isVisited[i] && child == 1) {
                    isVisited[i] = true;
                    queue.offer(i);
                }
            }
        }

    }
}