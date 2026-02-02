// BOJ 13549 - 숨바꼭질 3
// BFS
// https://www.acmicpc.net/problem/13549

import java.util.*;

class Pos {
    int point;
    int second;

    Pos(int point, int second) {
        this.point = point;
        this.second = second;
    }
}

class Main {
    int solution(int N, int K) {
        Deque<Pos> bfsQueue = new ArrayDeque<>();

        int[] costs = new int[100001];
        Arrays.fill(costs, Integer.MAX_VALUE);

        bfsQueue.add(new Pos(N, 0));
        costs[N] = 0;

        while(bfsQueue.size() > 0) {
            Pos front = bfsQueue.poll();

            if(front.point > 0 && front.point <= 50000) {
                int mul = front.point * 2;
                if(costs[mul] > front.second) {
                    bfsQueue.addFirst(new Pos(mul, front.second));
                    costs[mul] = front.second;

                    if(mul == K) {
                        return front.second;
                    }
                }
            }

            if(front.point > 0) {
                if(costs[front.point - 1] > front.second + 1) {
                    costs[front.point - 1] = front.second + 1;
                    bfsQueue.add(new Pos(front.point - 1, front.second + 1));
                    if(front.point - 1 == K) {
                        return front.second + 1;
                    }
                }
            }

            if(front.point < 100000) {
                if(costs[front.point + 1] > front.second + 1) {
                    costs[front.point + 1] = front.second + 1;
                    bfsQueue.add(new Pos(front.point + 1, front.second + 1));
                    if(front.point + 1 == K) {
                        return front.second + 1;
                    }
                }
            }

            if(front.point == K) {
                return front.second;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Main M = new Main();
        System.out.print(M.solution(N, K));
    }
}