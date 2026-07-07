package week23;
import java.util.*;
public class PGM_67259_HSH {
    static class Node {
        int x;
        int y;
        int dir;
        int cost;

        Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    private static int[] dirX = { -1, 0, 1, 0 };
    private static int[] dirY = { 0, 1, 0, -1 };

    static int cost[][][];
    public static void main(String[] args) {
        int[][] board = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        cost = new int[n][n][4]; // 세 번째 요소는 방향(어차피 상하좌우임)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<Node> queue = new LinkedList<>();
        // 네 방향으로 이동할 때 값을 넣어주기
        for (int i = 0; i < 4; i++) {
            cost[0][0][i] = 0; // 처음 시작은 0
            queue.offer(new Node(0, 0, i, 0)); // 방향을 우선 넣어둠 -> 이동할 방향과 일치하는지 체크하기 위함
        }
        // 큐에 있는걸 찾아와봅시다
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (int d = 0; d < 4; d++) {
                int curX = curNode.x;
                int curY = curNode.y;
                int nextX = curX + dirX[d];
                int nextY = curY + dirY[d];
                int nextCost = 0;
                // board 범위 내에서 놀 것
                if ((nextX >= 0 && nextX < n) && (nextY >= 0 && nextY < n)) {
                    // 벽이 아닐 것
                    if (board[nextX][nextY] != 1) {
                        if (curNode.dir == d) { // 현재 노드의 방향과 이동한 방향이 같은 경우
                            nextCost += curNode.cost + 100;
                        } else {
                            nextCost += curNode.cost + 600;
                        }

                        if (cost[nextX][nextY][d] > nextCost) {
                            cost[nextX][nextY][d] = nextCost; // d가 지금은 움직일 위치였음
                            queue.offer(new Node(nextX, nextY, d, nextCost));
                        }
                    }
                }
            }
        }

        answer = Integer.MAX_VALUE;
        // (n-1, n-1) 까지 갔을때 방향 이동에 대해서 현 값에 최소값을 구하기
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, cost[n - 1][n - 1][i]);
        }

        return answer;
    }
}